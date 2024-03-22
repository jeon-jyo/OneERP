<template>
  <div class="card mb-4">
    <div class="card-header pb-0">
      <h6>입고내역</h6>
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
                품목수  
              </th>
               <th
                class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2"
              >
                구매처
              </th>
              <th
                class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2"
              >
                입고완료일
              </th>
              <th
                class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2"
              >
                입고창고
              </th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="w in warehousing" v-bind:key="w.request_id">
              <td>
                <p class="text-sm font-weight-bold mb-0">{{ w.request_id }}</p>
              </td>
              <td>
                <p class="text-sm font-weight-bold mb-0">{{ w.re_qty }}</p>
              </td>
              <td>
                <p class="text-sm font-weight-bold mb-0">{{ w.cl_name }}</p>
              </td>
              <td>
                <p class="text-sm font-weight-bold mb-0">{{ w.inbound_date.substring(0, 10) }}</p>
              </td>
              <td>
                <p class="text-sm font-weight-bold mb-0">{{ w.wa_name }}</p>
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
  
  name: "warehousing-table",
  setup() {
    const store = useStore()

    const warehousing = computed(() => {
            return store.state.warehousing.warehousing
        }) 

    onMounted(async () => {
        await store.dispatch('warehousing/fetchList')
    })

    return{
      warehousing,
    }
  }
};


</script>
