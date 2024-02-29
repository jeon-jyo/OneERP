<template>

<Outbound v-if="isOutboundOpen" :id="id" @outboundClose="closeOutbound()" v-bind:isOutboundOpen="isOutboundOpen" />
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
                주문 번호
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
                판매일자
              </th>
              <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">
                출고일자
              </th>
              <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">
                납기요청일자
              </th>
              <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">
                승인상태
              </th>
              <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">
                출고상태
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
                <p class="text-sm font-weight-bold mb-0">{{ order.state }}</p>
              </td>
              <td>
                <span class="badge bg-warning text-dark" v-if="order.state == '요청'" @click="doSomething(order.request_id)">승인요청</span>
                <span class="badge bg-info text-dark" v-if="order.state == '신청'">승인대기</span>
                <span class="badge bg-light text-dark" v-if="order.state == '승인'">승인완료</span>
              </td>
              <td>
                <span class="badge bg-warning text-dark" v-if="order.re_status == '요청대기'" @click="openOutbound(order.request_id)">출고요청</span>
                <span class="badge bg-info text-dark" v-if="order.re_status == '요청'">출고대기</span>
                <span class="badge bg-light text-dark" v-if="order.re_status == '승인'">출고완료</span>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</template>

<script>

import Outbound from './Outbound.vue'
import Swal from 'sweetalert2'
import dayjs from 'dayjs'

import { ref, onMounted, computed } from 'vue'
import { useStore } from 'vuex'

// import { useRouter } from 'vue-router'

export default {
    name: 'projects-table',
    components: {
        Outbound
    },
    methods:{
    formatDay(dateString){
    const date = dayjs(dateString);
    return date.format('YYYY-MM-DD')
    }
  },
    // data() {
    //   return {
    //     id: ''
    //   }
    // },
    // setup() 함수는 vue2의 created() 상태와 동일하며, DOM이 만들어질 때 호출되는 함수이다.
    setup() {
        
        // const router = useRouter()
        
        const store = useStore()

        const doSomething = async (id) =>
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
              else {
                let obj = {
                    id: id ?? '',
                    abst: result.value ?? ''
                  }
                await store.dispatch('orderConfirm/updateslip', obj)
                await store.dispatch('orderList/fetchList')
              }
                  
                  });
                
            }

        const orderList = computed(() => {

            return store.state.orderList.orderList
        }) 
        
        // m-1. 모달창을 표시하기 위한 객체 기본값은 닫힌 상태(false), template 영역의 Outbound 컴포넌트를 확인
        const isOutboundOpen = ref(false)

        // m-2. 모달 렌더링용 함수 생성
        // 모달 띄움
        const openOutbound = async(id) => {
            await store.dispatch('productList/fetchList', id)
            isOutboundOpen.value = true
        }

        // 모달 닫음
        const closeOutbound = () => {
            isOutboundOpen.value = false
        }

        onMounted(async () => {
            await store.dispatch('orderList/fetchList')
        })

        return {
            orderList,
            isOutboundOpen,
            openOutbound,
            closeOutbound,
            Swal,
            doSomething
        }       
    },
}
</script>