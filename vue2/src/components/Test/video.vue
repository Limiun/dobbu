<template>
  <div class="homepage-hero-module">
    <div class="video-container" >
      <div :style="video.fixStyle" class="filter"></div>
      <video :style="video.fixStyle" autoplay loop class="fillWidth" v-on:canplay="canplay">
        <source src="../../assets/video/fj.mp4" type="video/mp4"/>
        浏览器不支持 video 标签，建议升级浏览器。
<!--        <source src="PATH_TO_WEBM" type="video/webm"/>-->
<!--        浏览器不支持 video 标签，建议升级浏览器。-->
      </video>
      <div style="z-index: 1 ;position: fixed">
        <h1 >test</h1>
      </div>
      <div style="z-index: 3 ;position: fixed">
        <h1 >test</h1>
      </div>


<!--      <div class="poster hidden" v-if="!vedioCanPlay">-->
<!--        <img :style="fixStyle" src="../../assets/logo.png" alt="">-->
<!--      </div>-->
    </div>
  </div>
</template>
<script>
  export default {
    name: 'video',
    data() {
      return {
        video:{
          vedioCanPlay: false,
          fixStyle: ''
        },

      }
    },
    methods: {
      canplay() {
        this.video.vedioCanPlay = true
      }
    },
    mounted: function() {
      window.onresize = () => {
        const windowWidth = document.body.clientWidth
        const windowHeight = document.body.clientHeight
        const windowAspectRatio = windowHeight / windowWidth
        let videoWidth
        let videoHeight
        if (windowAspectRatio < 0.5625) {
          videoWidth = windowWidth
          videoHeight = videoWidth * 0.5625
          this.video.fixStyle = {
            height: windowWidth * 0.5625 + 'px',
            width: windowWidth + 'px',
            'margin-bottom': (windowHeight - videoHeight) / 2 + 'px',
            'margin-left': 'initial'
          }
        } else {
          videoHeight = windowHeight
          videoWidth = videoHeight / 0.5625
          this.video.fixStyle = {
            height: windowHeight + 'px',
            width: windowHeight / 0.5625 + 'px',
            'margin-left': (windowWidth - videoWidth) / 2 + 'px',
            'margin-bottom': 'initial'
          }
        }
      }
      window.onresize()
    }
  }
</script>
<style scoped>
  .homepage-hero-module,
  .video-container {
    position: relative;
    height: 100vh;
    overflow: hidden;
  }

  .video-container .poster img,
  .video-container video {
    z-index: 0;
    position: absolute;
  }

  .video-container .filter {
    z-index: 1;
    position: absolute;
    background: rgba(0, 0, 0, 0.4);
  }
</style>
