////Описание задачи: Требуется реализовать REST эндпоинт для получения списка проектов в которых заданный пользователь
////        состоит в качестве администратора. Поскольку в системе существует большое количество проектов, требуется предусмотреть
////        параметр для ограничения результата.
//
//
//
//@RestController
//@RequestMapping(path = "api/v1/")
//public class UserController {
//
//    @Value("${response.limit}")
//    private int responseLimit;
//
//    @Autowired
//    private ProjectsService projectsService;
//
//    @GetMapping(path = "/projects/{userId}/admin/", method = RequestMethod.POST)
//    public Pagable getProjectsWhereUserIsAdmin(@PathVariable("userId") String userId, @RequestParam Integer offset, ) {
//        try {
//
//            final List<ProjectDTO> userProjects = getProjectsWithRetry()
//                    .stream()
//                    .filter(project -> project.getUserIds().contains(userId))
//                    .skip(offset)
//                    .limit(responseLimit)
//                    .toList();//collect(Collectors.toList());
//
//            return new ObjectMapper().writeValueAsString(userProjects);
//
//        } catch (Throwable t) {
//            System.err.println("Unexpected error: " + t.getMessage());
//            return "error";
//        }
//    }
//
//    @Transactional
//    private List<ProjectDTO> getProjectsWithRetry() {
//        return projectsService.getProjects();
//    }
//
//}
//
//
//
//@Data
//public class ProjectDTO {
//    private String id;
//    private String name;
//    private transient List<String> userIds;
//    private List<String> adminUserIds;
//}
//
//public interface ProjectsService {
//
//    List<ProjectDTO> getProjects();
//
//}