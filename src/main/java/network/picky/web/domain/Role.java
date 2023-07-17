package network.picky.web.domain;

@Getter
@RequiredArgsConstructor
public class Role {
    public enum Role {
        ADMIN("ROLE_ADMIN", "관리자"), MANAGER("ROLE_MANAGER", "매니저"), USER("ROLE_USER", "사용자");
        private final String key;
        private final String title;
    }
}