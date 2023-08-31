Ext.define('WorkshopRegistration.view.contract.ContractList', {
    extend: 'Tamin.panel.Panel',
    requires: ['WorkshopRegistration.view.contract.ContractController',
        'WorkshopRegistration.view.contract.ContractModel',
        'Tamin.ux.grid.PageSize'],
    xtype: 'contract-list',
    viewModel: {type: 'contract'},
    controller: 'contract',
    title: 'ردیف پیمان',
    items: [{
        xtype: 'tform',
        items: [{
            xtype: 'tfieldset',
            title: 'جستجو',
            items: [
                {
                    xtype: 'tform',
                    id: 'contract-list-id',
                    layout: {
                        type: 'table',
                        columns: 3,
                        tableAttrs: {style: {width: '100%', labelStyle: 'text-align:center'}}
                    },
                    defaults: {labelWidth: 130},
                    items: [
                        {
                            xtype: 'ttextfield',
                            fieldLabel: 'شماره قرارداد',
                            name: 'contractNumber'
                        },
                        {
                            xtype: 'ttextfield',
                            fieldLabel: 'کد کارگاه واگذارنده',
                            name: 'assignersWorkshop.workshopId'
                        },
                        {
                            xtype: 'tcombobox',
                            fieldLabel: 'نوع واگذارنده',
                            displayField: 'title',
                            valueField: 'id',
                            editable: true,
                            minChars: 2,
                            name: 'contractAssignType',
                            publishes: 'value',
                            bind: {store: '{AssignTypes}'}
                        },
                        {
                            xtype: 'tcombobox',
                            fieldLabel: 'ردیف پیمان',
                            displayField: 'contractRow',
                            valueField: 'contractRow',
                            name: 'contractRow',
                            editable: true,
                            pageSize: 5,
                            minChars: 2,
                            bind: {
                                store: '{Contracts}',
                                filters: {
                                    property: 'workshop.workshopId',
                                    value: '{workshopref.value}',
                                    operator: 'EQUAL'
                                }
                            },
                            triggerAction: 'last',
                            lastQuery: '',
                            listeners: {
                                beforequery: function (queryEvent) {
                                    if (arguments[0].combo.queryMode !== 'remote') {
                                        return queryEvent;
                                    }
                                    if (!queryEvent.cancel)
                                        if (queryEvent.query) {
                                            var filters = Ext.decode(queryEvent.query);
                                            filters.push({
                                                "property": "workshop.workshopId",
                                                "value": window.location.hash.split('/')[1],
                                                "operator": "EQUAL"
                                            });
                                            filters.push({
                                                "property": "workshop.branchCode",
                                                "value": window.location.hash.split('/')[2],
                                                "operator": 'EQUAL'
                                            });
                                            queryEvent.query = JSON.stringify(filters);
                                        }
                                    return queryEvent;
                                }
                            }
                        },
                        {
                            xtype: 'tcombobox',
                            fieldLabel: 'نرخ حق بیمه',
                            displayField: 'title',
                            valueField: 'id',
                            bind: {store: '{WorkshopPremiumRates}',},
                            editable: false,
                            pageSize: 10,
                            minChars: 2,
                            name: 'workshopPremiumRate.rateCode'
                        },
                        {
                            xtype: 'tcombobox',
                            fieldLabel: 'وضعیت',
                            name: 'contractStatus.contractStatusCode',
                            displayField: 'contractStatusDescription',
                            valueField: 'contractStatusCode',
                            store: Ext.create('Ext.data.Store', {
                                fields: [
                                    {type: 'string', name: 'contractStatusCode'},
                                    {type: 'string', name: 'contractStatusDescription'}
                                ],
                                data: [
                                    {"contractStatusCode": "00", "contractStatusDescription": "نامشخص"},
                                    {"contractStatusCode": "01", "contractStatusDescription": "فعال"},
                                    {"contractStatusCode": "02", "contractStatusDescription": "نیمه فعال"},
                                    {"contractStatusCode": "03", "contractStatusDescription": "راکد"},
                                    {"contractStatusCode": "04", "contractStatusDescription": "منتقل شده"},
                                    {"contractStatusCode": "05", "contractStatusDescription": "مختومه"},
                                    {"contractStatusCode": "09", "contractStatusDescription": "نامشخص"}
                                ]

                            }),
                            editable: false
                        },
                        {xtype: 'tdatefield', fieldLabel: 'تاریخ شروع قرارداد از', name: 'contractStartDate'},
                        {xtype: 'tdatefield', fieldLabel: 'تا تاریخ', name: 'toStartDate'},
                        {xtype: 'tdatefield', fieldLabel: 'تاریخ خاتمه قرارداد از', name: 'contractEndDate'},
                        {xtype: 'tdatefield', fieldLabel: 'تا تاریخ', name: 'toEndDate'},
                        {xtype: 'tdatefield', fieldLabel: 'تاریخ قرارداد از', name: 'contractDate'},
                        {xtype: 'tdatefield', fieldLabel: 'تا تاریخ', name: 'toContractDate'},
                        {
                            xtype: 'tcombo',
                            valueField: 'code',
                            displayField: 'name',
                            labelSeparator: false,
                            emptyText: 'انتخاب کنید...',
                            editable: false,
                            fieldLabel: 'مرحله کار',
                            name: 'status',
                            store: Ext.create('Ext.data.Store', {
                                fields: [{type: 'string', name: 'code'},
                                    {type: 'string', name: 'name'}],
                                data: [{"code": "0", "name": "در انتظار تایید سرپرست مطالبات"},
                                    {"code": "3", "name": "در انتظار تایید مسئول درآمد"}]

                            }),
                        },
                        // {
                        //     xtype: 'tcombo',
                        //     valueField: 'id',
                        //     displayField: 'title',
                        //     labelSeparator: false,
                        //     emptyText: 'انتخاب کنید...',
                        //     editable: false,
                        //     fieldLabel: 'نوع مقاطعه کار',
                        //     name: 'contractAssignType',
                        //     store: Ext.create('Ext.data.Store', {
                        //         fields: [{type: 'string', name: 'id'},
                        //             {type: 'string', name: 'title'}],
                        //         data: [{"id": "2", "title": "پیمانکار فرعی"},
                        //             {"id": "3", "title": "پیمانکار اصلی"}]
                        //
                        //     }),
                        // },

                        {
                            xtype: 'displayfield',
                            colspan: 2
                        },
                        {
                            xtype: 'hr', colspan: 3
                        },
                        {
                            xtype: 'buttoncontainer',
                            items: [{
                                xtype: 'tbutton',
                                text: 'جستجو',
                                name: 'btnSearch',
                                colspan: 3,
                                handler: 'onSearchButton',
                                iconCls: 'icon zoom'
                            }, {
                                xtype: 'tbutton',
                                text: 'همه موارد',
                                name: 'btnNewSearch',
                                handler: 'onNewSearch',
                                iconCls: 'icon arrow_refresh'
                            }, {
                                xtype: 'tbutton',
                                text: 'بازگشت به لیست پیمان',
                                name: 'btnAccept',
                                handler: 'onReturnToContractList',
                                iconCls: 'icon application_go'

                            }]
                        }]
                }]
        }, {
            xtype: 'tfieldset',
            title: 'لیست مشخصات اولیه پیمان ',
            items: [{
                xtype: 'tgrid',
                bind: {store: '{ContractStore}'},
                listeners: {cellclick: 'cellclick'},
                columns: [
                    {text: 'ردیف', xtype: 'rownumberer', autoSizeColumn: true, align: 'center', locked: true},
                    {
                        text: 'کد کارگاه', autoSizeColumn: true, locked: true,
                        renderer: function (val, data, record) {
                            return record.data.workshop.workshopId;
                        }
                    },
                    {
                        text: 'نوع', dataIndex: 'confidential', autoSizeColumn: true, hidden: true,
                        renderer: function (val, data, record) {
                            if (val == '0' || val == null || val == '') {
                                return 'غیر محرمانه';
                            } else if (val == '1') {
                                return 'محرمانه';
                            }
                        }
                    },
                    {
                        text: 'ردیف پیمان', autoSizeColumn: true, locked: true,
                        renderer: function (val, data, record) {
                            return record.data.contractRow;
                        }
                    },
                    {
                        text: 'شماره قرارداد', autoSizeColumn: true, locked: true,
                        renderer: function (val, data, record) {
                            const length = record.data.contractNumber.length;
                            if (length <= 45) {
                                return record.data.contractNumber;
                            } else {
                                return record.data.contractNumber.substr(0, 45) + '...';
                            }
                        },
                    },
                    {
                        text: 'تاریخ قرارداد', dataIndex: 'contractDate', autoSizeColumn: true, locked: true,
                        renderer: function (val, data, record) {
                            if (val !== null && val !== '') {
                                if (val.length === 6)
                                    return val.substr(0, 4) + '/' + val.substr(4, 2) + '/01';
                                else
                                    (val.length === 8)
                                return val.substr(0, 4) + '/' + val.substr(4, 2) + '/' + val.substr(6, 2);
                            }
                        }
                    },
                    {
                        text: 'وضعیت', autoSizeColumn: true, locked: true,
                        renderer: function (val, data, record) {
                            if (record.data.contractStatus != null)
                                return record.data.contractStatus.contractStatusDescription;
                        }
                    },
                    {
                        text: 'نرخ حق بیمه', autoSizeColumn: true,
                        renderer: function (val, data, record) {
                            if (record.data.workshopPremiumRate != null)
                                return record.data.workshopPremiumRate.rateDesc;
                        }
                    },
                    {
                        text: 'تاریخ شروع قرارداد', dataIndex: 'contractStartDate', autoSizeColmn: true,
                        renderer: function (val, data, record) {
                            if (val !== null && val !== '') {
                                if (val.length === 6)
                                    return val.substr(0, 4) + '/' + val.substr(4, 2) + '/01';
                                else
                                    (val.length === 8)
                                return val.substr(0, 4) + '/' + val.substr(4, 2) + '/' + val.substr(6, 2);
                            }
                        }
                    },
                    {
                        text: 'تاریخ خاتمه قرارداد', dataIndex: 'contractEndDate', autoSizeColumn: true,
                        renderer: function (val, data, record) {
                            if (val !== null && val !== '') {
                                if (val.length === 6)
                                    return val.substr(0, 4) + '/' + val.substr(4, 2) + '/01';
                                else
                                    (val.length === 8)
                                return val.substr(0, 4) + '/' + val.substr(4, 2) + '/' + val.substr(6, 2);
                            }
                        }
                    },
                    {
                        text: 'مبلغ اولیه قرارداد', dataIndex: 'contractAmount', autoSizeColumn: true,
                        renderer: function (val, data, record) {
                            if (val != null && val !== '') {
                                return val.toString().replace(/.(?=(?:.{3})+$)/g, '$&,');
                            } else {
                                return '-';
                            }
                        }
                    },
                    {
                        text: 'نام واگذارنده', dataIndex: 'contractAssignName', autoSizeColumn: true,
                        renderer: function (val, data, record) {
                            if (record.data.assignersWorkshop != null) {
                                return record.data.assignersWorkshop.workshopName;
                            } else if (record.data.model != null) {
                                return record.data.model.name;
                            } else if (record.data.fullName != null) {
                                return record.data.fullName;
                            }
                        }
                    },
                    {
                        text: 'کد/ شناسه ملی واگذارنده',
                        dataIndex: 'nationalCode',
                        autoSizeColumn: true,
                        align: 'center',
                        renderer: function (val, data, record) {
                            if (record.data.legalId !== null && record.data.legalId !== "")
                                return '<a href="javascript://none">' + record.data.legalId + '</a>';
                            else if (record.data.nationalId !== null && record.data.nationalId !== "")
                                return '<a href="javascript://none">' + record.data.nationalId + '</a>';
                            else
                                return '-';
                            // return (record.data.legalId !== null && record.data.legalId !== "") ? '<a href="javascript://none">' + record.data.legalId + '</a>' : '-';
                        }
                    },
                    {
                        text: 'کد کارگاهی واگذارنده',
                        autoSizeColumn: true,
                        align: 'center',
                        renderer: function (val, data, record) {
                            if (record.data.assignersWorkshop !== null && record.data.assignersWorkshop !== "")
                                return record.data.assignersWorkshop.workshopId;
                            else
                                return '-';
                        }
                    },
                    {
                        text: 'پیمان سرپرست', autoSizeColumn: true, align: 'center',
                        renderer: function (val, data, record) {
                            if (record.data.parentContract != null)
                                return 'دارد';
                            else
                                return 'ندارد';
                        }
                    },
                    {
                        xtype: 'actioncolumn',
                        align: 'center',
                        autoSizeColumn: true,
                        text: 'ویرایش',
                        items: [{
                            iconCls: 'icon pencil',
                            tooltip: 'ویرایش',
                            handler: 'onEditButton',
                            isDisabled: function (view, rowIndex, colIndex, item, record) {
                                var roles = WorkshopRegistration.getApplication().getUser().roles;
                                for (var i = 0; i <= roles.length - 1; i++) {
                                    if (roles[i].roleName == 'Workshop Admin' || roles[i].roleName == 'Workshop User') {
                                        return false;
                                    }
                                }
                                return true;
                            }
                        }]
                    },
                    {
                        xtype: 'actioncolumn',
                        align: 'center',
                        autoSizeColumn: true,
                        text: 'درخواست غیرحضوری',
                        items: [{
                            iconCls: 'icon zoom',
                            tooltip: 'مشاهده',
                            handler: 'onShowEserviceButton',
                            isDisabled: function (view, rowIndex, colIndex, item, record) {
                                return record.data.creatorSource !== 'eservice';
                            }
                        }]
                    },
                    {
                        xtype: 'actioncolumn',
                        align: 'center',
                        autoSizeColumn: true,
                        text: 'الحاقیه',
                        items: [{
                            iconCls: 'icon page_white_add',
                            tooltip: 'الحاقیه',
                            handler: 'onAddendumContractButton',
                            isDisabled: function (view, rowIndex, colIndex, item, record) {
                                var roles = WorkshopRegistration.getApplication().getUser().roles;
                                for (var i = 0; i <= roles.length - 1; i++) {
                                    if (((roles[i].roleName == 'Workshop Admin' || roles[i].roleName == 'Workshop User') && record.data.contractType != '')
                                        && record.data.isNew == null) {
                                        return false;
                                    }
                                }
                                return true;
                            }
                        }]
                    },
                    // {
                    //     xtype: 'actioncolumn',
                    //     align: 'center',
                    //     autoSizeColumn: true,
                    //     text: 'متمم',
                    //     items: [
                    //         {
                    //             iconCls: 'icon script_add',
                    //             tooltip: 'متمم',
                    //             handler: 'onAdditionContractButton',
                    //             isDisabled: function (view, rowIndex, colIndex, item, record) {
                    //                 var roles = WorkshopRegistration.getApplication().getUser().roles;
                    //                 for (var i = 0; i <= roles.length - 1; i++) {
                    //                     if (((roles[i].roleName == 'Workshop Admin' || roles[i].roleName == 'Workshop User') && record.data.contractType != '')
                    //                             && record.data.isNew == null) {
                    //                         return false;
                    //                     }
                    //                 }
                    //                 return true;
                    //             }
                    //         }
                    //     ]
                    // },
                    {
                        xtype: 'actioncolumn',
                        align: 'center',
                        text: ' سرپرست مطالبات',
                        autoSizeColumn: true,
                        items: [{
                            iconCls: 'icon display',
                            tooltip: 'تایید سرپرست مطالبات',
                            handler: 'onClaimApprove',
                            isDisabled: function (view, rowIndex, colIndex, item, record) {
                                if (record.data.status == "1") {
                                    return !record.get('editable');
                                }
                                var roles = WorkshopRegistration.getApplication().getUser().roles;
                                for (var i = 0; i <= roles.length - 1; i++) {
                                    if (roles[i].roleName == 'CLAIM ADMINISTRATORS' && record.data.status == '0') {
                                        return false;
                                    }
                                }
                                return true;
                            }
                        }]
                    },
                    {
                        xtype: 'actioncolumn',
                        align: 'center',
                        autoSizeColumn: true,
                        text: ' مسئول درآمد',
                        items: [{
                            iconCls: 'icon accept',
                            tooltip: 'تایید',
                            handler: 'onIncomApprove',
                            isDisabled: function (view, rowIndex, colIndex, item, record) {
                                var roles = WorkshopRegistration.getApplication().getUser().roles;
                                for (var i = 0; i <= roles.length - 1; i++) {
                                    if (roles[i].roleName == 'Workshop Admin' && record.data.status == '3') {
                                        return false;
                                    }
                                }
                                return true;
                            }
                        }]
                    },
                    {
                        xtype: 'actioncolumn',
                        align: 'center',
                        autoSizeColumn: true,
                        flex: 1,
                        text: 'پرونده الکترونیک',
                        items: [{
                            iconCls: 'icon folder',
                            tooltip: 'پرونده الکترونیک',
                            handler: 'onRedirectToRecord'
                        }]
                    },
                    {
                        xtype: 'actioncolumn',
                        align: 'center',
                        autoSizeColumn: true,
                        text: 'حذف',
                        items: [{
                            iconCls: 'icon cross',
                            tooltip: 'حذف',
                            handler: 'onDeleteButton',
                            isDisabled: function (view, rowIndex, colIndex, item, record) {
                                var roles = WorkshopRegistration.getApplication().getUser().roles;
                                for (var i = 0; i <= roles.length - 1; i++) {
                                    if (roles[i].roleName == 'Workshop Admin' && record.data.isNew === "1") {
                                        return false;
                                    }
                                }
                                return true;
                            }
                        }]
                    }
                ],
                dockedItems: [{
                    xtype: 'pagingtoolbar',
                    bind: {store: '{ContractStore}'},
                    plugins: ['pagesize'],
                    dock: 'bottom',
                    beforePageText: 'صفحه',
                    displayMsg: 'رکوردهای {0} تا {1} از مجموع {2}',
                    displayInfo: true
                }]
            },
                {
                    dock: 'bottom',
                    xtype: 'toolbar',
                    items: [
                        {
                            text: 'دریافت خروجی',
                            handler: 'onContractRowExport',
                            iconCls: 'icon page_excel',
                        },
                    ]
                },
                {xtype: 'hr'},
                {
                    xtype: 'buttoncontainer',
                    items: [{
                        xtype: 'tbutton',
                        text: 'پیمان',
                        handler: 'onAddContractButton',
                        iconCls: 'icon add',
                        disabled: true,
                        listeners: {
                            afterrender: function (paging, x, v) {
                                var me = this;
                                var roles = WorkshopRegistration.getApplication().getUser().roles;
                                for (var i = 0; i <= roles.length - 1; i++) {
                                    if (roles[i].roleName == 'Workshop Admin' || roles[i].roleName == 'Workshop User') {
                                        me.enable();
                                    }
                                }
                            }
                        }
                    }, {
                        xtype: 'tbutton',
                        text: 'پیمان محرمانه',
                        handler: 'onAddConfidentialContractButton',
                        iconCls: 'icon add',
                        disabled: true,
                        //                            listeners: {
                        //                                afterrender: function (paging, x, v) {
                        //                                    var me = this;
                        //                                    var roles = WorkshopRegistration.getApplication().getUser().roles;
                        //                                    for (var i = 0; i <= roles.length - 1; i++) {
                        //                                        if (roles[i].roleName == 'Workshop Admin' || roles[i].roleName == 'Workshop User') {
                        //                                            me.enable();
                        //                                        }
                        //                                    }
                        //                                }
                        //                            }
                    }]
                }]
        }]
    }]
});
