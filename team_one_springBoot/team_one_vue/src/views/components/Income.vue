<template>
  <div class="card mb-4">
    <div class="card-header pb-0">
      <h6>손익계산서</h6>
    </div>
    <div class="card-body px-0 pt-0 pb-2">
      <div class="table-responsive p-0">
        <table class="table align-items-center justify-content-center table-hover mb-0">
          <thead>
          <tr class="text-uppercase font-weight-bolder opacity-7 ps-2 table-secondary">
            <th colspan="4">
              손익계산서
            </th>
          </tr>
          </thead>
          <tbody>
            <tr class="text-uppercase text-xs font-weight-bolder">
              <td class="opacity-7 ps-2 table-light">문서</td>
              <td colspan="3">
                <div id="file_time"></div>
              </td>
            </tr>
            <tr class="text-uppercase text-xs font-weight-bolder opacity-7 ps-2 table-primary">
              <td>I. 매 출 액</td>
              <td class="text-danger"></td>
              <td></td>
              <td class="text-danger">{{ $filters.formatNumber(income.take_sales) }}</td>
            </tr>
            <tr class="text-uppercase text-xs font-weight-bolder">
              <td class="opacity-7 ps-2 table-light">상 품 매 출</td>
              <td class="text-danger">{{ $filters.formatNumber(income.take_sales) }}</td>
              <td></td>
              <td class="text-danger"></td>
            </tr>
            <tr class="text-uppercase text-xs font-weight-bolder opacity-7 ps-2 table-primary">
              <td>II. 매 출 원 가</td>
              <td class="text-danger"></td>
              <td></td>
              <td class="text-danger">{{ $filters.formatNumber((income.beginning_inventory + income.current_inventory) - income.ending_inventory) }}</td>
            </tr>
            <tr class="text-uppercase text-xs font-weight-bolder">
              <td class="opacity-7 ps-2 table-light text-danger fw-bold">상 품 매 출 원 가</td>
              <td class="text-danger"></td>
              <td></td>
              <td class="text-danger">{{ $filters.formatNumber((income.beginning_inventory + income.current_inventory) - income.ending_inventory) }}</td>
            </tr>
            <tr class="text-uppercase text-xs font-weight-bolder">
              <td class="opacity-7 ps-2 table-light">기초 상품 재고액</td>
              <td class="text-danger">{{ $filters.formatNumber(income.beginning_inventory) }}</td>
              <td></td>
              <td class="text-danger"></td>
            </tr>
            <tr class="text-uppercase text-xs font-weight-bolder">
              <td class="opacity-7 ps-2 table-light">당기 상품 매입액</td>
              <td class="text-danger">{{ $filters.formatNumber(income.current_inventory) }}</td>
              <td></td>
              <td class="text-danger"></td>
            </tr>
            <tr class="text-uppercase text-xs font-weight-bolder">
              <td class="opacity-7 ps-2 table-light">기말 상품 재고액</td>
              <td class="text-danger">{{ $filters.formatNumber(income.ending_inventory) }}</td>
              <td></td>
              <td class="text-danger"></td>
            </tr>
            <tr class="text-uppercase text-xs font-weight-bolder opacity-7 ps-2 table-success">
              <td>III. 매 출 총 이 익</td>
              <td class="text-danger"></td>
              <td></td>
              <td class="text-danger">{{ $filters.formatNumber(income.take_sales - ((income.beginning_inventory + income.current_inventory) - income.ending_inventory)) }}</td>
            </tr>
            <tr class="text-uppercase text-xs font-weight-bolder opacity-7 ps-2 table-warning">
              <td class="fw-bold">IV. 판 매 관 리 비</td>
              <td class="text-danger"></td>
              <td></td>
              <td class="text-danger">{{ $filters.formatNumber(income.total_salary + income.travel_expense + income.consumable_expense + income.communication_expense + income.entertainment_expense + income.administrative_expense + income.warehouse_expense) }}</td>
            </tr>
            <tr class="text-uppercase text-xs font-weight-bolder">
              <td class="opacity-7 ps-2 table-light">직 원 급 여</td>
              <td class="text-danger">{{ $filters.formatNumber(income.total_salary) }}</td>
              <td></td>
              <td class="text-danger"></td>
            </tr>
            <tr class="text-uppercase text-xs font-weight-bolder">
              <td class="opacity-7 ps-2 table-light">여 비 교 통 비</td>
              <td class="text-danger">{{ $filters.formatNumber(income.travel_expense) }}</td>
              <td></td>
              <td class="text-danger"></td>
            </tr>
            <tr class="text-uppercase text-xs font-weight-bolder">
              <td class="opacity-7 ps-2 table-light">접 대 비</td>
              <td class="text-danger">{{ $filters.formatNumber(income.travel_expense) }}</td>
              <td></td>
              <td class="text-danger"></td>
            </tr>
            <tr class="text-uppercase text-xs font-weight-bolder">
              <td class="opacity-7 ps-2 table-light">통 신 비</td>
              <td class="text-danger">{{ $filters.formatNumber(income.communication_expense) }}</td>
              <td></td>
              <td class="text-danger"></td>
            </tr>
            <tr class="text-uppercase text-xs font-weight-bolder">
              <td class="opacity-7 ps-2 table-light">수 도 광 열 비</td>
              <td class="text-danger">{{ $filters.formatNumber(income.administrative_expense) }}</td>
              <td></td>
              <td class="text-danger"></td>
            </tr>
            <tr class="text-uppercase text-xs font-weight-bolder">
              <td class="opacity-7 ps-2 table-light">소 모 품 비</td>
              <td class="text-danger">{{ $filters.formatNumber(income.consumable_expense) }}</td>
              <td></td>
              <td class="text-danger"></td>
            </tr>
            <tr class="text-uppercase text-xs font-weight-bolder">
              <td class="opacity-7 ps-2 table-light">창 고 관 리 비</td>
              <td class="text-danger">{{ $filters.formatNumber(income.warehouse_expense) }}</td>
              <td></td>
              <td class="text-danger"></td>
            </tr>
            <tr class="text-uppercase text-xs font-weight-bolder opacity-7 ps-2 table-warning">
              <td class="fw-bold">V. 영 업 이 익</td>
              <td class="text-danger"></td>
              <td></td>
              <td class="text-danger">{{ $filters.formatNumber(((income.beginning_inventory + income.current_inventory) - income.ending_inventory) - (income.total_salary + income.travel_expense + income.consumable_expense + income.communication_expense + income.entertainment_expense + income.administrative_expense + income.warehouse_expense)) }}</td>
            </tr>
            <tr class="text-uppercase text-xs font-weight-bolder">
              <td class="opacity-7 ps-2 table-light">VI. 영 업 외 수 익</td>
              <td class="text-danger"></td>
              <td></td>
              <td class="text-danger">-</td>
            </tr>
            <tr class="text-uppercase text-xs font-weight-bolder">
              <td class="opacity-7 ps-2 table-light">VII. 영 업 외 비 용</td>
              <td class="text-danger"></td>
              <td></td>
              <td class="text-danger">-</td>
            </tr>
            <tr class="text-uppercase text-xs font-weight-bolder">
              <td class="opacity-7 ps-2 table-light">VIII. 법인세 차감 전 순이익</td>
              <td class="text-danger"></td>
              <td></td>
              <td class="text-danger">{{ $filters.formatNumber(((income.beginning_inventory + income.current_inventory) - income.ending_inventory) - (income.total_salary + income.travel_expense + income.consumable_expense + income.communication_expense + income.entertainment_expense + income.administrative_expense + income.warehouse_expense)) }}</td>
            </tr>
            <tr class="text-uppercase text-xs font-weight-bolder opacity-7 ps-2 table-danger">
              <td>IX. 법 인 세</td>
              <td class="text-danger"></td>
              <td></td>
              <td class="text-danger">(과세표준 기준) {{ $filters.formatNumber((((income.beginning_inventory + income.current_inventory) - income.ending_inventory) - (income.total_salary + income.travel_expense + income.consumable_expense + income.communication_expense + income.entertainment_expense + income.administrative_expense + income.warehouse_expense) - income.non_tax_sum) * 0.1) }}</td>
            </tr>
            <tr class="text-uppercase text-xs font-weight-bolder opacity-7 ps-2 table-success">
              <td class="fw-bold">X. 당 기 순 이 익</td>
              <td class="text-danger"></td>
              <td></td>
              <td class="text-danger">{{ $filters.formatNumber(((income.beginning_inventory + income.current_inventory) - income.ending_inventory) - (income.total_salary + income.travel_expense + income.consumable_expense + income.communication_expense + income.entertainment_expense + income.administrative_expense + income.warehouse_expense) - ((((income.beginning_inventory + income.current_inventory) - income.ending_inventory) - (income.total_salary + income.travel_expense + income.consumable_expense + income.communication_expense + income.entertainment_expense + income.administrative_expense + income.warehouse_expense) - income.non_tax_sum) * 0.1)) }}</td>
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
  name: "income-table",
  setup() {
    const store = useStore()

    const income = computed(() => {
            return store.state.income.main
        }) 

    onMounted(async () => {
        await store.dispatch('income/fetchList')
    })
    console.log("sds",income)
    return{
      income,
    }
  }
};
</script>
