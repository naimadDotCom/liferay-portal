AUI.add(
	'liferay-asset-categories-selector',
	function(A) {
		var Lang = A.Lang;

		var AObject = A.Object;

		var BOUNDING_BOX = 'boundingBox';

		var CSS_TAGS_LIST = 'lfr-categories-selector-list';

		var EMPTY_FN = Lang.emptyFn;

		var ID = 'id';

		var NAME = 'categoriesselector';

		var STR_EXPANDED = 'expanded';

		var STR_PREV_EXPANDED = '_LFR_prevExpanded';

		var TPL_CHECKED = ' checked="checked" ';

		var TPL_INPUT =
			'<label title="{name}">' +
				'<span class="lfr-categories-selector-category-name" title="{name}">' +
					'<input data-categoryId="{categoryId}" data-vocabularyid="{vocabularyId}" name="{inputName}" type="{type}" value="{name}" {checked} />' +
					'{name}' +
				'</span>' +
				'<span class="lfr-categories-selector-search-results-path" title="{path}">{path}</span>' +
			'</label>';

		var TPL_MESSAGE = '<div class="lfr-categories-message">{0}</div>';

		var TPL_RADIO_CLASS = ' class="{0}" ';

		var TPL_RADIO_ID = ' id="{0}" ';

		var TPL_RADIO_IMAGE = '<div class="lfr-categories-selector-radio-image category{0}"></div>';

		var TPL_SEARCH_QUERY = '%{0}%';

		var TPL_SEARCH_RESULTS = '<div class="lfr-categories-selector-search-results"></div>';

		var URL_INVOKER = themeDisplay.getPathContext() + '/api/jsonws/invoke';

		/**
		 * OPTIONS
		 *
		 * Required
		 * className {String}: The class name of the current asset.
		 * curEntryIds (string): The ids of the current categories.
		 * curEntries (string): The names of the current categories.
		 * hiddenInput {string}: The hidden input used to pass in the current categories.
		 * instanceVar {string}: The instance variable for this class.
		 * labelNode {String|A.Node}: The node of the label element for this selector.
		 * title {String}: The title of the button element for this selector.
		 * vocabularyIds (string): The ids of the vocabularies.
		 * vocabularyGroupIds (string): The groupIds of the vocabularies.
		 *
		 * Optional
		 * maxEntries {Number}: The maximum number of entries that will be loaded. The default value is -1, which will load all categories.
		 * portalModelResource {boolean}: Whether the asset model is on the portal level.
		 */

		var AssetCategoriesSelector = A.Component.create(
			{
				ATTRS: {
					curEntries: {
						setter: function(value) {
							var instance = this;

							if (Lang.isString(value)) {
								value = value.split('_CATEGORY_');
							}

							return value;
						},
						value: ''
					},
					curEntryIds: {
						setter: function(value) {
							var instance = this;

							if (Lang.isString(value)) {
								value = value.split(',');
							}

							return value;
						},
						value: ''
					},
					labelNode: {
						setter: function(value) {
							return A.one(value) || A.Attribute.INVALID_VALUE;
						},
						value: null
					},
					maxEntries: {
						validator: Lang.isNumber,
						value: -1
					},
					singleSelect: {
						validator: Lang.isBoolean,
						value: false
					},
					title: {
						value: Liferay.Language.get('select-categories')
					},
					vocabularyIds: {
						setter: function(value) {
							var instance = this;

							if (Lang.isString(value) && value) {
								value = value.split(',');
							}

							return value;
						},
						value: []
					},
					vocabularyGroupIds: {
						setter: function(value) {
							var instance = this;

							if (Lang.isString(value) && value) {
								value = value.split(',');
							}

							return value;
						},
						value: []
					}
				},

				EXTENDS: Liferay.AssetTagsSelector,

				NAME: NAME,

				prototype: {
					UI_EVENTS: {},
					TREEVIEWS: {},

					renderUI: function() {
						var instance = this;

						AssetCategoriesSelector.superclass.constructor.superclass.renderUI.apply(instance, arguments);

						instance._renderIcons();

						instance.inputContainer.addClass('aui-helper-hidden-accessible');

						instance._applyARIARoles();
					},

					bindUI: function() {
						var instance = this;

						AssetCategoriesSelector.superclass.bindUI.apply(instance, arguments);
					},

					syncUI: function() {
						var instance = this;

						AssetCategoriesSelector.superclass.constructor.superclass.syncUI.apply(instance, arguments);

						var matchKey = instance.get('matchKey');

						instance.entries.getKey = function(obj) {
							return obj.categoryId;
						};

						var curEntries = instance.get('curEntries');
						var curEntryIds = instance.get('curEntryIds');

						A.each(
							curEntryIds,
							function(item, index, collection) {
								var entry = {
									categoryId: item
								};

								entry[matchKey] = curEntries[index];

								instance.entries.add(entry);
							}
						);
					},

					_afterTBLFocusedChange: EMPTY_FN,

					_applyARIARoles: function() {
						var instance = this;

						var boundingBox = instance.get(BOUNDING_BOX);
						var labelNode = instance.get('labelNode');

						if (labelNode) {
							boundingBox.attr('aria-labelledby', labelNode.attr(ID));

							labelNode.attr('for', boundingBox.attr(ID));
						}
					},

					_bindTagsSelector: EMPTY_FN,

					_clearEntries: function() {
						var instance = this;

						var entries = instance.entries;

						entries.each(A.fn('removeAt', entries, 0));
					},

					_formatJSONResult: function(json) {
						var instance = this;

						var output = [];

						var type = 'check';

						if (instance.get('singleSelect')) {
							type = 'radio';
						}

						A.each(
							json,
							function(item, index, collection) {
								var checked = false;
								var treeId = 'category' + item.categoryId;

								if (instance.entries.findIndexBy('categoryId', item.categoryId) > -1) {
									checked = true;
								}

								var newTreeNode = {
									after: {
										checkedChange: A.bind(instance._onCheckedChange, instance)
									},
									checked: checked,
									id: treeId,
									label: Liferay.Util.escapeHTML(item.titleCurrentValue),
									leaf: !item.hasChildren,
									type: type
								};

								output.push(newTreeNode);
							}
						);

						return output;
					},

					_formatRequestData: function(treeNode) {
						var instance = this;

						var data = {};

						data.p_auth = Liferay.authToken;

						var assetId = instance._getTreeNodeAssetId(treeNode);
						var assetType = instance._getTreeNodeAssetType(treeNode);

						if (Lang.isValue(assetId)) {
							if (assetType == 'category') {
								data.categoryId = assetId;
							}
							else {
								data.vocabularyId = assetId;
							}
						}

						return data;
					},

					_getEntries: function(className, callback) {
						var instance = this;

						var portalModelResource = instance.get('portalModelResource');

						var groupIds = [];

						var vocabularyIds = instance.get('vocabularyIds');

						if (vocabularyIds.length > 0) {
							instance._invokeService(
								{
									'$vocabularies = /assetvocabulary/get-vocabularies': {
										vocabularyIds: vocabularyIds.join(),

										'$categoriesCount = /assetcategory/get-vocabulary-categories-count': {
											'@groupId': '$vocabularies.groupId',
											'@vocabularyId': '$vocabularies.vocabularyId'
										}
									}
								},
								callback
							);
						}
						else {
							if (!portalModelResource && (themeDisplay.getParentGroupId() != themeDisplay.getCompanyGroupId())) {
								groupIds.push(themeDisplay.getParentGroupId());
							}

							groupIds.push(themeDisplay.getCompanyGroupId());

							instance._invokeService(
								{
									'$vocabularies = /assetvocabulary/get-groups-vocabularies': {
										groupIds: groupIds.join(),
										className: className,

										'$categoriesCount = /assetcategory/get-vocabulary-categories-count': {
											'groupId': '$vocabularies.groupId',
											'@vocabularyId': '$vocabularies.vocabularyId'
										}
									}
								},
								callback
							);
						}
					},

					_getTreeNodeAssetId: function(treeNode) {
						var treeId = treeNode.get(ID);
						var match = treeId.match(/(\d+)$/);

						return (match ? match[1] : null);
					},

					_getTreeNodeAssetType: function(treeNode) {
						var treeId = treeNode.get(ID);
						var match = treeId.match(/^(vocabulary|category)/);

						return (match ? match[1] : null);
					},

					_initSearch: function() {
						var instance = this;

						var popup = instance._popup;

						var vocabularyIds = instance.get('vocabularyIds');
						var vocabularyGroupIds = instance.get('vocabularyGroupIds');

						var searchResults = instance._searchResultsNode;

						if (!searchResults) {
							searchResults = A.Node.create(TPL_SEARCH_RESULTS);

							instance._searchResultsNode = searchResults;

							var processSearchResults = A.bind(
								instance._processSearchResults,
								instance,
								searchResults
							);

							var searchCategoriesTask = A.debounce(
								instance._searchCategories,
								350,
								instance,
								searchResults,
								vocabularyIds,
								vocabularyGroupIds,
								processSearchResults
							);

							var input = popup.searchField.get('node');

							input.on('keyup', searchCategoriesTask);

							if (instance.get('singleSelect')) {
								var onSelectChange = A.bind('_onSelectChange', instance);

								popup.entriesNode.delegate('change', onSelectChange, 'input[type=radio]');
							}
						}

						popup.entriesNode.append(searchResults);

						instance._searchBuffer = [];
					},

					_invokeService: function(payload, callback) {
						var instance = this;

						A.io.request(
							URL_INVOKER,
							{
								data: {
									cmd: A.JSON.stringify(payload),
									p_auth: Liferay.authToken
								},
								dataType: 'json',
								on: {
									success: function(event) {
										if (callback) {
											var data = this.get('responseData');

											callback.call(this, data);
										}
									}
								}
							}
						);
					},

					_onBoundingBoxClick: EMPTY_FN,

					_onCheckboxCheck: function(event) {
						var instance = this;

						var currentTarget = event.currentTarget;

						var assetId;
						var entryMatchKey;

						if (A.instanceOf(currentTarget, A.Node)) {
							assetId = currentTarget.attr('data-categoryId');

							entryMatchKey = currentTarget.val();
						}
						else {
							assetId = instance._getTreeNodeAssetId(currentTarget);

							entryMatchKey = currentTarget.get('label');
						}

						var matchKey = instance.get('matchKey');

						var entry = {
							categoryId: assetId
						};

						entry[matchKey] = entryMatchKey;

						instance.entries.add(entry);
					},

					_onCheckedChange: function(event) {
						var instance = this;

						if (event.newVal) {
							if (instance.get('singleSelect')) {
								instance._clearEntries();
							}

							instance._onCheckboxCheck(event);
						}
						else {
							instance._onCheckboxUncheck(event);
						}
					},

					_onCheckboxClick: function(event) {
						var instance = this;

						var method = '_onCheckboxUncheck';

						if (event.currentTarget.attr('checked')) {
							method = '_onCheckboxCheck';
						}

						instance[method](event);
					},

					_onCheckboxUncheck: function(event) {
						var instance = this;

						var currentTarget = event.currentTarget;

						var assetId;

						if (A.instanceOf(currentTarget, A.Node)) {
							assetId = currentTarget.attr('data-categoryId');
						}
						else {
							assetId = instance._getTreeNodeAssetId(currentTarget);
						}

						instance.entries.removeKey(assetId);
					},

					_onSelectChange: function(event) {
						var instance = this;

						instance._clearEntries();

						instance._onCheckboxCheck(event);
					},

					_processSearchResults: function(searchResults, results) {
						var instance = this;

						var buffer = instance._searchBuffer;

						buffer.length = 0;

						if (results.length > 0) {
							var inputType = 'checkbox';

							if (instance.get('singleSelect')) {
								inputType = 'radio';
							}

							var inputName = A.guid();

							A.each(
								results,
								function(item, index, collection) {
									item.checked = instance.entries.findIndexBy('categoryId', item.categoryId) > -1 ? TPL_CHECKED : '';

									item.inputName = inputName;
									item.type = inputType;

									buffer.push(Lang.sub(TPL_INPUT, item));
								}
							);
						}
						else {
							var message = Lang.sub(TPL_MESSAGE, [Liferay.Language.get('no-categories-found')]);

							buffer.push(message);
						}

						searchResults.removeClass('loading-animation');

						searchResults.html(buffer.join(''));
					},

					_renderIcons: function() {
						var instance = this;

						var contentBox = instance.get('contentBox');

						instance.icons = new A.Toolbar(
							{
								children: [
									{
										handler: {
											context: instance,
											fn: instance._showSelectPopup
										},
										icon: 'search',
										label: Liferay.Language.get('select'),
										title: instance.get('title')
									}
								]
							}
						).render(contentBox);

						var iconsBoundingBox = instance.icons.get(BOUNDING_BOX);

						instance.entryHolder.placeAfter(iconsBoundingBox);
					},

					_searchCategories: function(event, searchResults, vocabularyIds, vocabularyGroupIds, callback) {
						var instance = this;

						var searchValue = Lang.trim(event.currentTarget.val());

						if (searchValue && !event.isNavKey()) {
							searchResults.empty();

							searchResults.addClass('loading-animation');

							var serviceParameterTypesSearch = [
								'[J',
								'java.lang.String',
								'[J',
								'int',
								'int'
							];

							Liferay.Service.Asset.AssetCategory.search(
								{
									groupIds: vocabularyGroupIds,
									name: Lang.sub(TPL_SEARCH_QUERY, [searchValue]),
									vocabularyIds: vocabularyIds,
									start: -1,
									end: -1,
									serviceParameterTypes: A.JSON.stringify(serviceParameterTypesSearch)
								},
								callback
							);
						}

						searchResults.toggle(!!searchValue);

						var treeViews = instance.TREEVIEWS;

						AObject.each(
							treeViews,
							function(item, index, collection) {
								item.toggle(!searchValue);
							}
						);
					},

					_showSelectPopup: function(event) {
						var instance = this;

						instance._showPopup(event);

						var popup = instance._popup;

						popup.set('title', Liferay.Language.get('categories'));

						popup.entriesNode.addClass(CSS_TAGS_LIST);

						var className = instance.get('className');

						instance._getEntries(
							className,
							function(entries) {
								popup.entriesNode.empty();

								A.each(entries, instance._vocabulariesIterator, instance);

								A.each(
									instance.TREEVIEWS,
									function(item, index, collection) {
										item.expandAll();
									}
								);
							}
						);

						if (instance._bindSearchHandle) {
							instance._bindSearchHandle.detach();
						}

						var searchField = popup.searchField.get(BOUNDING_BOX);

						instance._bindSearchHandle = searchField.once('focus', instance._initSearch, instance);
					},

					_vocabulariesIterator: function(item, index, collection) {
						var instance = this;

						var popup = instance._popup;
						var vocabularyTitle = Liferay.Util.escapeHTML(item.titleCurrentValue);
						var vocabularyId = item.vocabularyId;

						if (item.groupId == themeDisplay.getCompanyGroupId()) {
							vocabularyTitle += ' (' + Liferay.Language.get('global') + ')';
						}

						var treeId = 'vocabulary' + vocabularyId;

						var paginatorConfig = {
							offsetParam: 'start'
						};

						var maxEntries = instance.get('maxEntries');

						if (maxEntries > 0) {
							paginatorConfig.limit = maxEntries;
							paginatorConfig.moreResultsLabel = Liferay.Language.get('load-more-results');
							paginatorConfig.total = item.categoriesCount;
						}
						else {
							paginatorConfig.end = -1;
							paginatorConfig.start = -1;
						}

						var vocabularyRootNode = {
							alwaysShowHitArea: true,
							id: treeId,
							label: vocabularyTitle,
							leaf: false,
							paginator: paginatorConfig,
							type: 'io'
						};

						instance.TREEVIEWS[vocabularyId] = new A.TreeView(
							{
								children: [vocabularyRootNode],
								io: {
									cfg: {
										data: A.bind(instance._formatRequestData, instance),
										on: {
											success: function(event) {
												var treeViews = instance.TREEVIEWS;

												var tree = treeViews[vocabularyId];

												var children = tree.get('children');

												if (!children || !children.length || !children[0].hasChildNodes()) {
													tree.destroy();

													delete treeViews[vocabularyId];
												}
											}
										}
									},
									formatter: A.bind(instance._formatJSONResult, instance),
									url: themeDisplay.getPathMain() + '/asset/get_categories'
								}
							}
						).render(popup.entriesNode);
					}
				}
			}
		);

		Liferay.AssetCategoriesSelector = AssetCategoriesSelector;
	},
	'',
	{
		requires: ['aui-tree', 'liferay-asset-tags-selector']
	}
);