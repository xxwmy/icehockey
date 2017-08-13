/**
 * Created by Administrator on 2017/7/15.
 */
const IPCONFIG='http://127.0.0.1:8080/icehockey/';//全局iP地址url verificationCode
const VERIFICATIONCODE=IPCONFIG+'';//获取验证码
const LOGIN_API=IPCONFIG+'LoginServlet';// login api url
const ISLOGIN_NAME='isLogin';//登陆之后设置的名称
const HobbyURL=IPCONFIG+'HobbyChooseServlet'; //我是选择玩雪还是玩冰或者两者都玩
const ICEURL=IPCONFIG+'HobbySelectIceServlet';//我是玩冰的
const SNOWURL=IPCONFIG+'HobbySelectSnowServlet';//我是玩雪的
const HANDLINGURL=IPCONFIG+'ChiganfangshiServlet';//持杆方式url
const ROLEURL=IPCONFIG+'RoleServlet';//角色url
const GENDERURL=IPCONFIG+'GenderServlet';//性别选择url
const HEIGHTURL=IPCONFIG+'HeightServlet';//身高选择url
const WEIGHTURL=IPCONFIG+'WeightServlet';//体重选择url
const BODYURL=IPCONFIG+'BodyServlet';//其他信息选择url
const ALIASURL=IPCONFIG+'AliasServlet';//头像选择url
const MYINFOURL=IPCONFIG+'MyInfoServlet';//我的个人信息url
const MYESSENTIALINFOURL=IPCONFIG+'MyEssentialInfoServlet';//我的基本信息url
const LEARNFROMURL=IPCONFIG+'LearnfromServlet';//师从教练url
const GETHONORURL=IPCONFIG+'GethonorServlet';//获得荣誉url
const EXPERIENCEURL=IPCONFIG+'ExperienceServlet';//球员经历url
const ERROR_URL=IPCONFIG+'ErrorServlet';//错误页面url
const ENJOYEDURL=IPCONFIG+'EnjoyedServlet';//参加赛事url
const GROUPNOWURL=IPCONFIG+'GroupnowServlet';//当前组别url
const DEGREEURL=IPCONFIG+'DegreeServlet';//等级资质url
const TEACHCLUBURL=IPCONFIG+'TeachclubServlet';//执教俱乐部url
const TEACHTEAMURL=IPCONFIG+'TeachteamServlet';//执教球队url
const JUDGEEXPERIENCEURL=IPCONFIG+'JudgeExperienceServlet';//执法经历url
const OFTENSITEMURL=IPCONFIG+'OftensiteServlet';//常去场地url
const EQUIPMENTURL=IPCONFIG+'EquipmentServlet';//装备url
const MYACTIVITYURL=IPCONFIG+'EquipmentServlet';//装备url
const MYPHOTOURL=IPCONFIG+'EquipmentServlet';//装备url