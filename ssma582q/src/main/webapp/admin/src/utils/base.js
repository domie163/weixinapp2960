const base = {
    get() {
        return {
            url : "http://localhost:8080/ssma582q/",
            name: "ssma582q",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/ssma582q/front/h5/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "基于微信小程序的场地预约"
        } 
    }
}
export default base
