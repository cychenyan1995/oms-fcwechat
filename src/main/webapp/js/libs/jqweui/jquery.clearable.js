(function($) {
    var dom = '<i class="clearable"></i>';
    var Clearable = function(element, options) {
        var defaults = {
            width: 16,
            height: 16
        };
        this.setting = $.extend({}, defaults, options);
        var toggleFlag = false;
        var callback = this.setting.callback;

        function toggle() {
            $dom.toggle();
            toggleFlag = !toggleFlag;
            if(typeof(callback) != "undefined"){
            	callback();
            }
        }

        var $element = $(element).on('keyup.clearable focus.clearable paste.clearable', function() {
            var self = this;
        	setTimeout(function(){
            	if (!!$(self).val().trim() !== toggleFlag) {
                    toggle();
                }
            },0);
        });

        var p = $element.position();
        var width = $element.width();
        var height = $element.height();
        var mt = parseFloat($element.css('margin-top'));
        var ml = parseFloat($element.css('margin-left'));

        var $dom = $(dom).css({
                left: p.left + width + ml - this.setting.width - 5 + 'px',
                top: p.top + mt + (height - this.setting.height) / 2 - 1 + 'px'
            })
            .on('click.clearable',function() {
                $element.val('');
                toggle();
            })
            .insertAfter($element);
        this.init();
        
    };
    Clearable.prototype = {
        init: function() {}
    };
    $.fn.clearable = function(options) {
        return this.each(function(key, value) {
            var element = $(this);

            if (element.data('clearable')) {
                return element.data('clearable');
            }
            var clearable = new Clearable(this, options);

            element.data('clearable', clearable);

            return clearable;
        });
    };
})(jQuery);
