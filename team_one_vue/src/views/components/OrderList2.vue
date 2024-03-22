<template>

  <Inbound v-if="isInboundOpen"  @inboundClose="closeInbound()" v-bind:isInboundOpen="isInboundOpen" />
  <div class="card mb-4">
    <div class="card-header pb-0">
      <h6>주문서 목록</h6>
    </div>
    <div class="card-body px-0 pt-0 pb-2">
      <div class="table-responsive p-0">
        <table class="table align-items-center justify-content-center table-hover mb-0">
          <thead>
            <tr>
              <th
                class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2"
              >
                주문서 번호
              </th>
              <th
                class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2"
              >
                판매처
              </th>
              <th
                class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2"
              >
                대표자
              </th>
              <th
                class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2"
              >
                판매처 연락처
              </th>
              <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">
                담당자
              </th>
              <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">
                구매일자
              </th>
              <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">
                입고일자
              </th>
              <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">
                승인상태
              </th>
              <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">
                입고상태
              </th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="order in orderList" v-bind:key="order.request_id">
              <td>
                <p class="text-sm font-weight-bold mb-0">{{ order.request_id }}</p>
              </td>
              <td>
                <p class="text-sm font-weight-bold mb-0">{{ order.cl_name }}</p>
              </td>
              <td>
                <p class="text-sm font-weight-bold mb-0">{{ order.ceo_name }}</p>
              </td>
              <td>
                <p class="text-sm font-weight-bold mb-0">{{ order.cl_phone.substring(0,3) }}-{{ order.cl_phone.substring(3,7) }}-{{ order.cl_phone.substring(7,11) }}</p>
              </td>
              <td>
                <p class="text-sm font-weight-bold mb-0">{{ order.em_name }}</p>
              </td>
              <td>
                <p class="text-sm font-weight-bold mb-0">{{ formatDay(order.begin_date)}}</p>
              </td>
              <td>
                <p class="text-sm font-weight-bold mb-0">{{ formatDay(order.end_date)}}</p>
              </td>
              <td>
                <span class="badge bg-warning text-dark" v-if="order.state == '요청'" @click="doSomething(order.request_id)">승인요청</span>
                <span class="badge bg-info text-dark" v-if="order.state == '신청'" >승인대기</span>
                <span class="badge bg-light text-dark" v-if="order.state == '승인'">승인완료</span>
              </td>
              <td>
                <span class="badge bg-warning text-dark" v-if="order.re_status == '요청대기'" @click="openInbound(order.request_id)">입고요청</span>
                <span class="badge bg-info text-dark" v-if="order.re_status == '요청'" >입고대기</span>
                <span class="badge bg-light text-dark" v-if="order.re_status == '승인'">입고완료</span>
              </td>
            </tr>
          </tbody>
        </table>

      </div>
    </div>
  </div>
</template>

<script>

import { onMounted, computed, ref } from 'vue'
import { useStore } from 'vuex'
import dayjs from 'dayjs'
import Swal from 'sweetalert2'
import Inbound from './Inbound.vue'

export default {
  name: "projects-table",
    components: {
        Inbound,
    },

  methods:{
    formatDay(dateString){
    const date = dayjs(dateString);
    return date.format('YYYY-MM-DD')
    }
  },
  
  setup() {
    const store = useStore()
    const doSomething = (id) =>
    {
       Swal.fire({
          title: '적요를 입력해주세요.',
          input: 'text',
    }).then( async(result) => {
      if(result.value==null){
    				Swal.fire({
                     title: '적요를 입력하지 않았습니다.',
    	    		       icon: "error" 
    	    		  })
    	    		  return;
    			}
      else{
        let obj = {
            id: id ?? '',
            abstract: result.value ?? ''
          }
           await store.dispatch('slip/updateslip', obj)
           await store.dispatch('orderList2/fetchList')
      }
          
    		});
       
    }

    const orderList = computed(() => {
            return store.state.orderList2.orderList
        }) 

    const isInboundOpen = ref(false);

    const openInbound =  async(id) => {
       
        await store.dispatch('productList2/fetchList', id)
        await store.dispatch('warehouseList/fetchList')
        isInboundOpen.value = true
        
    }

    // 모달 닫음
    const closeInbound = () => {
        isInboundOpen.value = false
    }

    onMounted(async () => {
        await store.dispatch('orderList2/fetchList')
    })

    return{
      orderList,
      isInboundOpen,
      openInbound,
      closeInbound,
      Swal,
      doSomething,
      
    }
  }
}

</script>
