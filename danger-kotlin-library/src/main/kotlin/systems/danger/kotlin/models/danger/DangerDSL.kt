package systems.danger.kotlin.models.danger

import kotlinx.serialization.*
import systems.danger.kotlin.models.bitbucket.BitBucketServer
import systems.danger.kotlin.models.git.Git
import systems.danger.kotlin.models.github.GitHub
import systems.danger.kotlin.models.gitlab.GitLab

@Serializable
internal data class DSL(
    val danger: DangerDSL
)

@Serializable
data class DangerDSL(
    @SerialName("github")
    private val _github: GitHub? = null,
    @SerialName("bitbucket_server")
    private val _bitBucketServer: BitBucketServer? = null,
    @SerialName("gitlab")
    private val _gitlab: GitLab? = null,
    val git: Git
) {
    val github: GitHub
        get() = _github!!
    val bitBucketServer: BitBucketServer
        get() = _bitBucketServer!!
    val gitlab: GitLab
        get() = _gitlab!!

    val onGitHub
        get() = _github != null
    val onBitBucketServer
        get() = _bitBucketServer != null
    val onGitLab
        get() = _gitlab != null

    val utils: Utils
        get() = Utils()
}
