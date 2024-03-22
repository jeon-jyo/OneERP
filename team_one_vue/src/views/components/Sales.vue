<template>
  <div class="card mb-4">
    <div class="card-header pb-0">
      <h6>매출집계표</h6>
    </div>
    <div class="card-body px-0 pt-0 pb-2">
      <div class="table-responsive p-0">
        <table class="table align-items-center justify-content-center table-hover mb-0">
          <thead>
            <tr>
              <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">
                전표번호
              </th>
              <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">
                계정과목
              </th>
              <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">
                거래처
              </th>
              <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">
                적요
              </th>
              <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">
                공급가액
              </th>
              <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">
                세액
              </th>
              <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">
                합계액
              </th>
              <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">
                발행일자
              </th>
              <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">
                승인일자
              </th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="purchase in purchaseOutList" v-bind:key="purchase.sale_slip_id">
              <td>
                <p class="text-sm font-weight-bold mb-0">{{ purchase.sale_slip_id }}</p>
              </td>
              <td>
								<p class="text-sm font-weight-bold mb-0">{{purchase.sa_account_title}}{{purchase.sa_type}}</p>
              </td>
              <td>
                <p class="text-sm font-weight-bold mb-0">{{ purchase.cl_name }}</p>
              </td>
              <td>
                <p class="text-sm font-weight-bold mb-0">{{ purchase.sa_abstract }}</p>
              </td>
              <td> 
					    	<p class="text-sm font-weight-bold mb-0">{{purchase.supply_amount}}</p>
              </td>
              <td>
                <p class="text-sm font-weight-bold mb-0">{{ purchase.tax_amount }}</p>
              </td>
              <td>
                <p class="text-sm font-weight-bold mb-0">{{purchase.supply_amount + purchase.tax_amount}}</p>
              </td>
              <td>
                <p class="text-sm font-weight-bold mb-0">{{ formatDay(purchase.sl_register_date)}}</p>
              </td>
              <td>
                <p class="text-sm font-weight-bold mb-0" v-if="purchase.update_date">{{ formatDay(purchase.update_date)}}</p>
                <span class="badge bg-gradient-secondary badge-sm null null" v-else-if="!purchase.update_date">승인대기</span>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</template>

<script>

import { onMounted, computed } from 'vue'
import { useStore } from 'vuex'
import dayjs from 'dayjs'

export default {
  name: "projects-table",
   
  methods:{
    formatDay(dateString){
    const date = dayjs(dateString);
    return date.format('YYYY-MM-DD')
    }
  },
  setup() {
    const store = useStore()

    const purchaseOutList = computed(() => {
            return store.state.purchaseOutList.purchaseOutList
        }) 

    onMounted(async () => {
        await store.dispatch('purchaseOutList/fetchList')
    })

    return{
      purchaseOutList
    }
  }
};
</script>
