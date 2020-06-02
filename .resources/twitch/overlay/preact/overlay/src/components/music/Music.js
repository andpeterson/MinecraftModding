import {useState, useRef} from 'preact/hooks';
import Helmet from 'preact-helmet';
import YouTube from 'react-youtube';

const youtubeOptions = {
  width: 0,
  height: 0,

  playerVars: {
    autoplay: 1,        // Auto-play the video on load
    controls: 0,        // Show pause/play buttons in player
    showinfo: 0,        // Hide the video title
    modestbranding: 1,  // Hide the Youtube Logo
    disablekb: 1,
    loop: 1,            // Run the video in a loop
    fs: 0,              // Hide the full screen button
    cc_load_policy: 0,  // Hide closed captions
    iv_load_policy: 3,  // Hide the Video Annotations
    autohide: 1,        // Hide video controls when playing
    enablejsapi: 1
  }
}
//player.current.playVideo();
//player.current.pauseVideo();
//player.current.nextVideo();
const listId = "PL6NdkXsPL07KiewBDpJC1dFvxEubnNOp1"

const Music = (props) => {
  const [title, setTitle] = useState("undefined");
  const player = useRef(null);

  const onReady = (event) => {
    player.cuePlaylist({
      listType: 'playlist',
      list: listId
    });
  }

  //may want to add a toast to this
  const onError = (event) => {
    console.error(event);
    player.current.nextVideo();
  }

  const onPlay = (event) => {
    setTitle(event.target.playerInfo.videoData.title)
  }

  const onStateChange = () => {
    const onAir = () => {
      player.setLoop(true);
      player.playVideo();
      player.setVolume(volume);
    }
    switch(event.data){
      case -1:  // Not started
        var done = false;
        setTimeout(() => {
          if (player.getCurrentTime() < 0 && !done) {
            player.nextVideo();
            done = true;
          }
        }, 5000);
        break;
      // Stopped
      case 0: onAir(); break;
      // Playing
      case 1: onAir(); break;
      // Pause
      case 2: onAir(); break;
      case 3: onAir(); break;
      // In queue
      case 5: onAir(); break;
      default: onAir();              
    }
  }

  // onPlay={func}                     // defaults -> noop
  // onPause={func}                    // defaults -> noop
  // onEnd={func}                      // defaults -> noop
  // onError={func}                    // defaults -> noop
  // onStateChange={func}              // defaults -> noop
  // onPlaybackRateChange={func}       // defaults -> noop
  // onPlaybackQualityChange={func}    // defaults -> noop

  return (
    <>
      <YouTube videoId={'fx7wbQ7i1ug'} opts={youtubeOptions} onReady={onReady} onError={onError} onStateChange={onStateChange}/>
      <div id="title">{title}</div>
    </>
  );
}

export default Music;