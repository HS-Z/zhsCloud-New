
//form 表单序列化并转json
var formJson = function (formId) {
    var _params = {};
    $.each($('#' + formId).serializeArray(), function (i, field) {
        _params[field.name] = field.value;
    });
    return _params;
};