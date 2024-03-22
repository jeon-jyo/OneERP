<template>
  <div class="card mb-4">
    <div class="card-header pb-0">
      <h6>출/퇴근 기록</h6>
    </div>
    <div class="card-body px-0 pt-0 pb-2">
      <div class="table-responsive p-0">
        <table class="table align-items-center justify-content-center table-hover mb-0">
          <thead>
            <tr>
            <th
                class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2"
              >
               근태코드
            </th>
              <th
                class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2"
              >
                날짜
              </th>
              <th
                class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2"
              >
                근무
              </th>
              <th
                class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2"
              >
                출근시간
              </th>
              <th
                class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2"
              >
                퇴근시간
              </th>

            </tr>
          </thead>
          <tbody>
            <tr v-for="p in commute" v-bind:key="p.attendance_id">
              <td>
                <p class="text-sm font-weight-bold mb-0">{{ p.attendance_id }}</p>
              </td>
              <td>
                <p class="text-sm font-weight-bold mb-0">{{formatDay(p.at_start_date) }}</p>
              </td>
              <td>
                <p class="text-sm font-weight-bold mb-0">{{ p.attendance_status }}</p>
              </td>
            <td>
                <p class="text-sm font-weight-bold mb-0">{{ formatTime(p.at_start_date) }}</p>
              </td>
              <td>
                <p class="text-sm font-weight-bold mb-0">{{ formatTime(p.at_end_date) }}</p>
              </td>          

            </tr>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</template>

<script>

import { onMounted, computed} from 'vue'
import { useStore } from 'vuex'
import dayjs from "dayjs"

export default {
  
  name: "commute-table",
  setup() {
    const store = useStore()

    const commute = computed(() => {
            return store.state.commute.commute
        }) 

        

    onMounted(async () => {
        await store.dispatch('commute/fetchList')
    })

    

    return{
      commute,
    }
  },
    methods: {
        formatDay(dateString) {
            const date = dayjs(dateString);
          
            return date.format( 'YY년 MM월 D일');
        },
        formatTime(dateString){
            const date = dayjs(dateString);
            
            return date.format( 'HH:mm');

        }

    }

};


</script>
