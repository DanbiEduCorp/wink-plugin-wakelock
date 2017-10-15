# wink-plugin-wakelock

usage :
```javascript
navigator.wakelock.aquire(function(err) {
    if (err) {
        return console.error('aquire fail', err);
    }
    console.log('aquire success');
});
```

log 확인하기 : D/REMEDU_WAKELOCK: aquire