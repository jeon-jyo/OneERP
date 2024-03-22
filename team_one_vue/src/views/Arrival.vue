<template>
  <div class="card mb-4">
    <div class="card-header pb-0">
      <h6>입하내역</h6>
    </div>
    <div class="card-body px-0 pt-0 pb-2">
      <div class="table-responsive p-0">
        <table class="table align-items-center justify-content-center table-hover mb-0">
          <thead>
            <tr>
              <th
                class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2"
              >
                요청코드
              </th>
              <th
                class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2"
              >
                구매처
              </th>
               <th
                class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2"
              >
                요청일
              </th>
              <th
                class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2"
              >
                입하예정일
              </th>
              <th
                class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2"
              >
                입하예정창고
              </th>
               <th
                class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2"
              >
                품목수
              </th>
               <th
                class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2"
              >
                입하지시
              </th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="a in arrival" v-bind:key="a.request_id">
              <td>
                <p class="text-sm font-weight-bold mb-0">{{ a.request_id }}</p>
              </td>
             <td>
                <p class="text-sm font-weight-bold mb-0">{{ a.cl_name }}</p>
              </td>
              <td>
                <p class="text-sm font-weight-bold mb-0">{{ a.begin_date.substring(0, 10) }}</p>
              </td>
              <td>
                <p class="text-sm font-weight-bold mb-0">{{ a.inbound_date.substring(0, 10) }}</p>
              </td>
              <td>
                <p class="text-sm font-weight-bold mb-0">{{ a.wa_name }}</p>
              </td>
               <td>
                <p class="text-sm font-weight-bold mb-0">{{ a.re_qty }}</p>
              </td>
               <td>
                <p class="text-sm font-weight-bold mb-0">{{ a.inbound_status}}</p>
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






export default {
  
  name: "arrival-table",
  setup() {
    const store = useStore()

    const arrival = computed(() => {
            return store.state.arrival.arrival
        }) 

    onMounted(async () => {
        await store.dispatch('arrival/fetchList')
    })

    return{
      arrival,
    }
  }
};


</script>
