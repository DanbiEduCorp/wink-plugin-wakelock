# wink-plugin-wakelock

deep sleep에 빠져서 유휴상태로 진입한 CPU를 강제로 깨우는 플러그인. 영상 전화/화상 수업 요청을 상대방으로부터 받았을때 이를 사용해서 깨운다.

## Installation

  cordova plugin add https://github.com/DanbiEduCorp/wink-plugin-wakelock.git --save

## usage :
```javascript
navigator.wakelock.aquire(function(err) {
    if (err) {
        return console.error('aquire fail', err);
    }
    console.log('aquire success');
});
```

log 확인하기 : D/REMEDU_WAKELOCK: aquire
