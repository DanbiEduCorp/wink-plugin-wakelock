var exec = require('cordova/exec');
var PLUGIN_NAME = 'wakelock';

var wakelock = {
    aquire: function(callback) {
        callback = callback || (function() {});
        exec(function(){callback();}, callback, PLUGIN_NAME, 'aquire', []);
    },
    relaese: function(callback) {
        callback = callback || (function() {});
        exec(function(){callback();}, callback, PLUGIN_NAME, 'release', []);
    },
    isHeld: function(callback) {
        callback = callback || (function() {});
        exec(function(){callback();}, callback, PLUGIN_NAME, 'isHeld', []);
    }
};

module.exports = wakelock;
