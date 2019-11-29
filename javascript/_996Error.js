
(function(window) {
    var defaultContent = 
            '尊敬的游客/开发者，您好，您所浏览的网站是由一个996公司开发的。\n' +
            '何为996？，请浏览 https://github.com/996icu/996.ICU/blob/master/README_CN.md';

    function print(str) {
        var content = str || defaultContent;
        console.log(content)
    }

    function _throw(str) {
        var content = str || defaultContent;
        throw Error(content)
    }

    function _996Error() {
        return {
            print: print,
            _throw: _throw
        };
    }

    window._996Error = _996Error;
})(window);
