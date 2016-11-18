<link rel="stylesheet" type="text/css" href="/css/select2.min.css">
<script src="/js/select2.full.min.js"></script>
<div>
    <h1 class="page-header">输入提交示例</h1>

    <div>
        <div class="row">
            <form action="" id="params">
                <div class="col-sm-12 col-md-6 col-lg-3">
                    <div class="form-group">
                        <label class="control-label">姓名：</label>
                        <input class="form-control" size="16" type="text" value="" id="patientName" name="patientName"
                               title="姓名"/>
                    </div>
                </div>
                <div class="col-sm-12 col-md-6 col-lg-3">
                    <div class="form-group">
                        <label class="control-label">身份证：</label>
                        <input class="form-control" size="16" type="text" value="" id="identityNo" name="identityNo"
                               title="身份证"/>
                    </div>
                </div>
                <div class="col-sm-12 col-md-6 col-lg-3">
                    <div class="form-group">
                        <label class="control-label">收件人</label>
                        <select class="form-control selectpicker" name="recipient" id="recipient"
                                data-live-search="true" title="请选择...">
                            <option value="***@hotmail.com">Jack</option>
                        </select>
                    </div>
                </div>
                <div class="col-sm-12 col-md-6 col-lg-3">
                    <div class="form-group">
                        <label class="control-label">select2示例</label>
                        <select class="form-control selectpicker" name="example" id="example"
                                title="请选择"></select>
                    </div>
                </div>
                <div class="col-sm-12 col-md-6 col-lg-3">
                    <div class="form-group">
                        <label class="control-label">&nbsp;</label><br/>
                        <input type="submit" class="btn btn-primary search-btn" value="查询"/>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<script src="/js/queryInfo.js"></script>
<script src="/js/jquery.form.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $('#params').submit(function () {
            document.getElementById("params").action = "/customer/queryFirst";
            document.getElementById("params").action += "?userName=" + $("#example").find("option:selected").text();
            $("#params").ajaxSubmit(function (res) {
                if (res.success) {
                    alertShow(res.message);
                } else {
                    alertShow(res.message);
                    return false;
                }
            });
            return false;
        });
    });
</script>