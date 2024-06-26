import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [react()],
  server: {
    proxy: {
      "/api": "http://backend:8082"
    },
    host: "0.0.0.0",
    open: "http://localhost:5173/login"
  }
})
