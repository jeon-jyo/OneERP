<template>
  <div class="py-4 container-fluid">
    <div class="row">
      <div class="col-12">
        <dept-table />
      </div>
    </div>
  </div>
</template>

<script>
import DeptTable from "./components/Dept.vue";

export default {
  name: "dstables",
  components: {
    DeptTable,
  },
};
</script>
