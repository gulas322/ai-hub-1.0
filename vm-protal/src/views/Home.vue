<template>
  <div class="home" :class="{ 'dark': isDark }">
    <div class="container">
      <h1 class="title">XX汽车 AI 工具中心</h1>
      <div class="cards-grid">
        <router-link 
          v-for="app in aiApps" 
          :key="app.id"
          :to="app.route"
          class="card"
        >
          <div class="card-content">
            <component :is="app.icon" class="icon" />
            <h2>{{ app.title }}</h2>
            <p>{{ app.description }}</p>
          </div>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import { useDark } from '@vueuse/core'
import { 
  ChatBubbleLeftRightIcon,
  HeartIcon,
  UserGroupIcon,
  DocumentTextIcon
} from '@heroicons/vue/24/outline'

const isDark = useDark()

const aiApps = ref([
  {
    id: 1,
    title: 'AI 聊天',
    description: '多模态对话机器人，支持图片、音频等',
    route: '/ai-chat',
    icon: ChatBubbleLeftRightIcon
  },
  {
    id: 2,
    title: '汽车预约智能客服',
    description: '24小时在线的预约咨询师',
    route: '/customer-service',
    icon: UserGroupIcon
  },
  {
    id: 3,
    title: 'RAG',
    description: '知识库，与知识库自由对话',
    route: '/chat-pdf',
    icon: DocumentTextIcon
  }
])
</script>

<style scoped lang="scss">
.home {
  min-height: 100vh;
  padding: 2rem;
  background: linear-gradient(135deg, var(--bg-color), var(--bg-color) 60%, rgba(0, 124, 240, 0.05));
  transition: all 0.3s ease;
  perspective: 1000px;

  .container {
    max-width: 1400px;
    margin: 0 auto;
    padding: 0 2rem;
  }

  .title {
    text-align: center;
    font-size: 2.8rem;
    font-weight: 700;
    margin-bottom: 4rem;
    background: linear-gradient(135deg, #007CF0, #00DFD8);
    -webkit-background-clip: text;
    -webkit-text-fill-color: transparent;
    letter-spacing: -0.5px;
    animation: fadeIn 1.2s cubic-bezier(0.4, 0, 0.2, 1);
  }

  .cards-grid {
    display: grid;
    grid-template-columns: repeat(1, 1fr);
    gap: 2.5rem;
    justify-items: center;
    padding: 1rem;

    @media (min-width: 768px) {
      grid-template-columns: repeat(2, 1fr);
    }
    
    @media (min-width: 1200px) {
      grid-template-columns: repeat(3, 1fr);
      gap: 3rem;
    }
  }

  .card {
    position: relative;
    width: 100%;
    max-width: 360px;
    background: rgba(255, 255, 255, 0.7);
    backdrop-filter: blur(12px);
    border-radius: 24px;
    padding: 2.5rem;
    text-decoration: none;
    color: inherit;
    transition: all 0.4s cubic-bezier(0.4, 0, 0.2, 1);
    border: 1px solid rgba(255, 255, 255, 0.2);
    overflow: hidden;
    animation: float 6s ease-in-out infinite;
    transform-style: preserve-3d;
    box-shadow: 0 0 20px rgba(0, 223, 216, 0.1);

    &:nth-child(2) {
      animation-delay: -2s;
    }

    &:nth-child(3) {
      animation-delay: -4s;
    }

    &::before {
      content: '';
      position: absolute;
      top: 0;
      left: 0;
      right: 0;
      bottom: 0;
      background: linear-gradient(135deg, rgba(255, 255, 255, 0.1), rgba(255, 255, 255, 0));
      opacity: 0;
      transition: opacity 0.4s ease;
    }

    .dark & {
      background: rgba(255, 255, 255, 0.03);
      border: 1px solid rgba(255, 255, 255, 0.05);
    }

    &:hover {
      transform: translateY(-8px) scale(1.02);
      box-shadow: 0 20px 40px rgba(0, 0, 0, 0.08);
      
      &::before {
        opacity: 1;
      }

      .dark & {
        box-shadow: 0 20px 40px rgba(0, 0, 0, 0.3);
        background: rgba(255, 255, 255, 0.05);
      }

      .icon {
        transform: scale(1.1);
        color: #00DFD8;
      }
    }

    .card-content {
      display: flex;
      flex-direction: column;
      align-items: center;
      text-align: center;
      position: relative;
      z-index: 1;
    }

    .icon {
      width: 56px;
      height: 56px;
      margin-bottom: 1.5rem;
      color: #007CF0;
      transition: all 0.4s ease;

      &.heart-icon {
        color: #ff4d4f;
        animation: pulse 2s ease-in-out infinite;
      }
    }

    h2 {
      font-size: 1.8rem;
      font-weight: 600;
      margin-bottom: 1rem;
      background: linear-gradient(135deg, #2a2a2a, #4a4a4a);
      -webkit-background-clip: text;
      -webkit-text-fill-color: transparent;

      .dark & {
        background: linear-gradient(135deg, #ffffff, #cccccc);
        -webkit-background-clip: text;
        -webkit-text-fill-color: transparent;
      }
    }

    p {
      color: #555;
      font-size: 1.1rem;
      line-height: 1.6;
      margin-top: 0.5rem;
      opacity: 0.9;

      .dark & {
        color: #bbb;
      }
    }
  }

  &.dark {
    background: linear-gradient(135deg, #1a1a1a, #1a1a1a 60%, rgba(0, 124, 240, 0.05));
  }
}

@keyframes fadeIn {
  from {
    opacity: 0;
    transform: translateY(30px);
  }
  to {
    opacity: 1;
    transform: translateY(0);
  }
}

@keyframes float {
  0%, 100% {
    transform: translateY(0) translateX(0) rotate3d(1, 1, 1, 0deg);
  }
  25% {
    transform: translateY(-15px) translateX(10px) rotate3d(1, 1, 1, 3deg);
  }
  50% {
    transform: translateY(0) translateX(-5px) rotate3d(1, 1, 1, 0deg);
  }
  75% {
    transform: translateY(15px) translateX(5px) rotate3d(1, 1, 1, -3deg);
  }
}

@keyframes pulse {
  0% {
    transform: scale(1);
  }
  50% {
    transform: scale(1.1);
  }
  100% {
    transform: scale(1);
  }
}

@media (max-width: 768px) {
  .home {
    padding: 1.5rem;
    
    .container {
      padding: 0 1rem;
    }
    
    .title {
      font-size: 2.2rem;
      margin-bottom: 3rem;
    }

    .card {
      max-width: 100%;
      padding: 2rem;

      h2 {
        font-size: 1.6rem;
      }

      p {
        font-size: 1rem;
      }
    }
  }
}
</style>