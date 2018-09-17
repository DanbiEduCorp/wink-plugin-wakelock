var exec = require('cordova/exec');
var PLUGIN_NAME = 'wakelock';

var wakelock = {
    aquire: function(callback) {
        callback = callback || (function() {});
        exec(function(){callback();}, callback, PLUGIN_NAME, 'aquire', []);
    },
    release: function(successCallback, errorCallback) {
        errorCallback = errorCallback || (function() {});
        exec(successCallback, errorCallback, PLUGIN_NAME, 'release', []);
    },
    isHeld: function(successCallback, errorCallback) {
        errorCallback = errorCallback || (function() {});
        exec(successCallback, errorCallback, PLUGIN_NAME, 'isHeld', []);
    }
};

module.exports = wakelock;
