<template>
  <div class="card mb-4">
    <div class="card-header pb-0">
      <h6>창고목록</h6>
                <p class="text-sm font-weight-bold mb-0">
                </p>
                  <span class="badge bg-gradient-secondary badge-sm null null">창고등록</span>
     </div>
    <div class="card-body px-0 pt-0 pb-2">
      <div class="table-responsive p-0">
        <table class="table align-items-center justify-content-center table-hover mb-0">
          <thead>
            <tr>
              <th
                class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2"
              >
                창고ID
              </th>
              <th
                class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2"
              >
                창고명
              </th>
              <th
                class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2"
              >
                사용용적
              </th>
              <th
                class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2"
              >
                등록일
              </th>
              <th
                class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2"
              >
                상태
              </th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="l in logisics" v-bind:key="l.wh_id">
              <td>
                <p class="text-sm font-weight-bold mb-0">{{ l.wh_id }}</p>
              </td>
              <td>
                <p class="text-sm font-weight-bold mb-0">{{ l.wa_name }}</p>
              </td>
              <td>
                <p class="text-sm font-weight-bold mb-0">{{ l.volume }}</p>
              </td>
              <td>
                <p class="text-sm font-weight-bold mb-0">{{ l.wa_reg_date.substring(0, 10) }}</p>
              </td>
              <td>
                <p class="text-sm font-weight-bold mb-0">{{ l.wa_status }}</p>
              </td>
            </tr>
          </tbody>
        </table>
        <!-- <button><router-link to="/release">출고내역</router-link></button> -->
      </div>
    </div>
  </div>
</template>

<script>

import { onMounted, computed} from 'vue'
import { useStore } from 'vuex'
import dayjs from 'dayjs'





export default {
  
  name: "logisics-table",
    methods:{
    formatDay(dateString){
    const date = dayjs(dateString);
    return date.format('YYYY-MM-DD')
    }
  },
  setup() {
    const store = useStore()

    const logisics = computed(() => {
            return store.state.logisics.logisics
        }) 

    onMounted(async () => {
        await store.dispatch('logisics/fetchList')
    })

    return{
      logisics,
    }
  }
};


</script>
