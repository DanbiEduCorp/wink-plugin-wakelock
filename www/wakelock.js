var exec = require('cordova/exec');
var PLUGIN_NAME = 'wakelock';

var wakelock = {
    aquire: function(callback) {
        callback = callback || (function() {});
        exec(function(){callback();}, callback, PLUGIN_NAME, 'aquire', []);
    }
};

module.exports = wakelock;
