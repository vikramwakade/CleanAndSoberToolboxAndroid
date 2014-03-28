




<!DOCTYPE html>
<html class="  ">
  <head prefix="og: http://ogp.me/ns# fb: http://ogp.me/ns/fb# object: http://ogp.me/ns/object# article: http://ogp.me/ns/article# profile: http://ogp.me/ns/profile#">
    <meta charset='utf-8'>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    
    
    <title>CleanAndSoberToolboxAndroid/App/src/com/osu/cleanandsobertoolboxandroid/MainActivity.java at master · whatnot15/CleanAndSoberToolboxAndroid</title>
    <link rel="search" type="application/opensearchdescription+xml" href="/opensearch.xml" title="GitHub" />
    <link rel="fluid-icon" href="https://github.com/fluidicon.png" title="GitHub" />
    <link rel="apple-touch-icon" sizes="57x57" href="/apple-touch-icon-114.png" />
    <link rel="apple-touch-icon" sizes="114x114" href="/apple-touch-icon-114.png" />
    <link rel="apple-touch-icon" sizes="72x72" href="/apple-touch-icon-144.png" />
    <link rel="apple-touch-icon" sizes="144x144" href="/apple-touch-icon-144.png" />
    <meta property="fb:app_id" content="1401488693436528"/>

      <meta content="@github" name="twitter:site" /><meta content="summary" name="twitter:card" /><meta content="whatnot15/CleanAndSoberToolboxAndroid" name="twitter:title" /><meta content="CleanAndSoberToolboxAndroid - Android App - Clean and Sober Toolbox" name="twitter:description" /><meta content="https://avatars2.githubusercontent.com/u/5564880?s=400" name="twitter:image:src" />
<meta content="GitHub" property="og:site_name" /><meta content="object" property="og:type" /><meta content="https://avatars2.githubusercontent.com/u/5564880?s=400" property="og:image" /><meta content="whatnot15/CleanAndSoberToolboxAndroid" property="og:title" /><meta content="https://github.com/whatnot15/CleanAndSoberToolboxAndroid" property="og:url" /><meta content="CleanAndSoberToolboxAndroid - Android App - Clean and Sober Toolbox" property="og:description" />

    <link rel="assets" href="https://github.global.ssl.fastly.net/">
    <link rel="conduit-xhr" href="https://ghconduit.com:25035/">
    <link rel="xhr-socket" href="/_sockets" />

    <meta name="msapplication-TileImage" content="/windows-tile.png" />
    <meta name="msapplication-TileColor" content="#ffffff" />
    <meta name="selected-link" value="repo_source" data-pjax-transient />
    <meta content="collector.githubapp.com" name="octolytics-host" /><meta content="collector-cdn.github.com" name="octolytics-script-host" /><meta content="github" name="octolytics-app-id" /><meta content="B83912AC:5ADD:1DCF9CD:53360C3F" name="octolytics-dimension-request_id" /><meta content="3997931" name="octolytics-actor-id" /><meta content="vikramwakade" name="octolytics-actor-login" /><meta content="c9be51625240d0a05e13c9c9e9845168141186d2162023fd46447474e9d89415" name="octolytics-actor-hash" />
    

    
    
    <link rel="icon" type="image/x-icon" href="https://github.global.ssl.fastly.net/favicon.ico" />

    <meta content="authenticity_token" name="csrf-param" />
<meta content="XqkUeWgF2ybro1T9GMKT3PgHeaP8L5F+AC94fIHpYBU=" name="csrf-token" />

    <link href="https://github.global.ssl.fastly.net/assets/github-b4baae9c06716bcd0a8068e3030607851f19b980.css" media="all" rel="stylesheet" type="text/css" />
    <link href="https://github.global.ssl.fastly.net/assets/github2-4940da06adce480cfcfba223624a2b2f09e8f90f.css" media="all" rel="stylesheet" type="text/css" />
    


        <script crossorigin="anonymous" src="https://github.global.ssl.fastly.net/assets/frameworks-4ffe0645461d6fd51485ee3e555a732ee7075743.js" type="text/javascript"></script>
        <script async="async" crossorigin="anonymous" src="https://github.global.ssl.fastly.net/assets/github-be9bb8cee5629f9422386c2b296840f56b94111e.js" type="text/javascript"></script>
        
        
      <meta http-equiv="x-pjax-version" content="953f6de137720540a11c6200aa7f5c16">

        <link data-pjax-transient rel='permalink' href='/whatnot15/CleanAndSoberToolboxAndroid/blob/ce20938a0476b966a64b70f76d800674854e7b91/App/src/com/osu/cleanandsobertoolboxandroid/MainActivity.java'>

  <meta name="description" content="CleanAndSoberToolboxAndroid - Android App - Clean and Sober Toolbox" />

  <meta content="5564880" name="octolytics-dimension-user_id" /><meta content="whatnot15" name="octolytics-dimension-user_login" /><meta content="16620248" name="octolytics-dimension-repository_id" /><meta content="whatnot15/CleanAndSoberToolboxAndroid" name="octolytics-dimension-repository_nwo" /><meta content="true" name="octolytics-dimension-repository_public" /><meta content="false" name="octolytics-dimension-repository_is_fork" /><meta content="16620248" name="octolytics-dimension-repository_network_root_id" /><meta content="whatnot15/CleanAndSoberToolboxAndroid" name="octolytics-dimension-repository_network_root_nwo" />
  <link href="https://github.com/whatnot15/CleanAndSoberToolboxAndroid/commits/master.atom" rel="alternate" title="Recent Commits to CleanAndSoberToolboxAndroid:master" type="application/atom+xml" />

  </head>


  <body class="logged_in  env-production windows vis-public page-blob">
    <a href="#start-of-content" class="accessibility-aid js-skip-to-content">Skip to content</a>
    <div class="wrapper">
      
      
      
      


      <div class="header header-logged-in true">
  <div class="container clearfix">

    <a class="header-logo-invertocat" href="https://github.com/">
  <span class="mega-octicon octicon-mark-github"></span>
</a>

    
    <a href="/notifications" aria-label="You have no unread notifications" class="notification-indicator tooltipped tooltipped-s" data-gotokey="n">
        <span class="mail-status all-read"></span>
</a>

      <div class="command-bar js-command-bar  in-repository">
          <form accept-charset="UTF-8" action="/search" class="command-bar-form" id="top_search_form" method="get">

<div class="commandbar">
  <span class="message"></span>
  <input type="text" data-hotkey="/ s" name="q" id="js-command-bar-field" placeholder="Search or type a command" tabindex="1" autocapitalize="off"
    
    data-username="vikramwakade"
      data-repo="whatnot15/CleanAndSoberToolboxAndroid"
      data-branch="master"
      data-sha="3a9817cd79739df10117944a0083f563c416a982"
  >
  <div class="display hidden"></div>
</div>

    <input type="hidden" name="nwo" value="whatnot15/CleanAndSoberToolboxAndroid" />

    <div class="select-menu js-menu-container js-select-menu search-context-select-menu">
      <span class="minibutton select-menu-button js-menu-target" role="button" aria-haspopup="true">
        <span class="js-select-button">This repository</span>
      </span>

      <div class="select-menu-modal-holder js-menu-content js-navigation-container" aria-hidden="true">
        <div class="select-menu-modal">

          <div class="select-menu-item js-navigation-item js-this-repository-navigation-item selected">
            <span class="select-menu-item-icon octicon octicon-check"></span>
            <input type="radio" class="js-search-this-repository" name="search_target" value="repository" checked="checked" />
            <div class="select-menu-item-text js-select-button-text">This repository</div>
          </div> <!-- /.select-menu-item -->

          <div class="select-menu-item js-navigation-item js-all-repositories-navigation-item">
            <span class="select-menu-item-icon octicon octicon-check"></span>
            <input type="radio" name="search_target" value="global" />
            <div class="select-menu-item-text js-select-button-text">All repositories</div>
          </div> <!-- /.select-menu-item -->

        </div>
      </div>
    </div>

  <span class="help tooltipped tooltipped-s" aria-label="Show command bar help">
    <span class="octicon octicon-question"></span>
  </span>


  <input type="hidden" name="ref" value="cmdform">

</form>
        <ul class="top-nav">
          <li class="explore"><a href="/explore">Explore</a></li>
            <li><a href="https://gist.github.com">Gist</a></li>
            <li><a href="/blog">Blog</a></li>
          <li><a href="https://help.github.com">Help</a></li>
        </ul>
      </div>

    


  <ul id="user-links">
    <li>
      <a href="/vikramwakade" class="name">
        <img alt="vikramwakade" class=" js-avatar" data-user="3997931" height="20" src="https://avatars1.githubusercontent.com/u/3997931?s=140" width="20" /> vikramwakade
      </a>
    </li>

    <li class="new-menu dropdown-toggle js-menu-container">
      <a href="#" class="js-menu-target tooltipped tooltipped-s" aria-label="Create new...">
        <span class="octicon octicon-plus"></span>
        <span class="dropdown-arrow"></span>
      </a>

      <div class="new-menu-content js-menu-content">
      </div>
    </li>

    <li>
      <a href="/settings/profile" id="account_settings"
        class="tooltipped tooltipped-s"
        aria-label="Account settings ">
        <span class="octicon octicon-tools"></span>
      </a>
    </li>
    <li>
      <a class="tooltipped tooltipped-s" href="/logout" data-method="post" id="logout" aria-label="Sign out">
        <span class="octicon octicon-log-out"></span>
      </a>
    </li>

  </ul>

<div class="js-new-dropdown-contents hidden">
  

<ul class="dropdown-menu">
  <li>
    <a href="/new"><span class="octicon octicon-repo-create"></span> New repository</a>
  </li>
  <li>
    <a href="/organizations/new"><span class="octicon octicon-organization"></span> New organization</a>
  </li>


    <li class="section-title">
      <span title="whatnot15/CleanAndSoberToolboxAndroid">This repository</span>
    </li>
      <li>
        <a href="/whatnot15/CleanAndSoberToolboxAndroid/issues/new"><span class="octicon octicon-issue-opened"></span> New issue</a>
      </li>
</ul>

</div>


    
  </div>
</div>

      

        



      <div id="start-of-content" class="accessibility-aid"></div>
          <div class="site" itemscope itemtype="http://schema.org/WebPage">
    
    <div class="pagehead repohead instapaper_ignore readability-menu">
      <div class="container">
        

<ul class="pagehead-actions">

    <li class="subscription">
      <form accept-charset="UTF-8" action="/notifications/subscribe" class="js-social-container" data-autosubmit="true" data-remote="true" method="post"><div style="margin:0;padding:0;display:inline"><input name="authenticity_token" type="hidden" value="XqkUeWgF2ybro1T9GMKT3PgHeaP8L5F+AC94fIHpYBU=" /></div>  <input id="repository_id" name="repository_id" type="hidden" value="16620248" />

    <div class="select-menu js-menu-container js-select-menu">
      <a class="social-count js-social-count" href="/whatnot15/CleanAndSoberToolboxAndroid/watchers">
        4
      </a>
      <span class="minibutton select-menu-button with-count js-menu-target" role="button" tabindex="0" aria-haspopup="true">
        <span class="js-select-button">
          <span class="octicon octicon-eye-unwatch"></span>
          Unwatch
        </span>
      </span>

      <div class="select-menu-modal-holder">
        <div class="select-menu-modal subscription-menu-modal js-menu-content" aria-hidden="true">
          <div class="select-menu-header">
            <span class="select-menu-title">Notification status</span>
            <span class="octicon octicon-remove-close js-menu-close"></span>
          </div> <!-- /.select-menu-header -->

          <div class="select-menu-list js-navigation-container" role="menu">

            <div class="select-menu-item js-navigation-item " role="menuitem" tabindex="0">
              <span class="select-menu-item-icon octicon octicon-check"></span>
              <div class="select-menu-item-text">
                <input id="do_included" name="do" type="radio" value="included" />
                <h4>Not watching</h4>
                <span class="description">You only receive notifications for conversations in which you participate or are @mentioned.</span>
                <span class="js-select-button-text hidden-select-button-text">
                  <span class="octicon octicon-eye-watch"></span>
                  Watch
                </span>
              </div>
            </div> <!-- /.select-menu-item -->

            <div class="select-menu-item js-navigation-item selected" role="menuitem" tabindex="0">
              <span class="select-menu-item-icon octicon octicon octicon-check"></span>
              <div class="select-menu-item-text">
                <input checked="checked" id="do_subscribed" name="do" type="radio" value="subscribed" />
                <h4>Watching</h4>
                <span class="description">You receive notifications for all conversations in this repository.</span>
                <span class="js-select-button-text hidden-select-button-text">
                  <span class="octicon octicon-eye-unwatch"></span>
                  Unwatch
                </span>
              </div>
            </div> <!-- /.select-menu-item -->

            <div class="select-menu-item js-navigation-item " role="menuitem" tabindex="0">
              <span class="select-menu-item-icon octicon octicon-check"></span>
              <div class="select-menu-item-text">
                <input id="do_ignore" name="do" type="radio" value="ignore" />
                <h4>Ignoring</h4>
                <span class="description">You do not receive any notifications for conversations in this repository.</span>
                <span class="js-select-button-text hidden-select-button-text">
                  <span class="octicon octicon-mute"></span>
                  Stop ignoring
                </span>
              </div>
            </div> <!-- /.select-menu-item -->

          </div> <!-- /.select-menu-list -->

        </div> <!-- /.select-menu-modal -->
      </div> <!-- /.select-menu-modal-holder -->
    </div> <!-- /.select-menu -->

</form>
    </li>

  <li>
  

  <div class="js-toggler-container js-social-container starring-container ">
    <a href="/whatnot15/CleanAndSoberToolboxAndroid/unstar"
      class="minibutton with-count js-toggler-target star-button starred"
      aria-label="Unstar this repository" title="Unstar whatnot15/CleanAndSoberToolboxAndroid" data-remote="true" data-method="post" rel="nofollow">
      <span class="octicon octicon-star-delete"></span><span class="text">Unstar</span>
    </a>

    <a href="/whatnot15/CleanAndSoberToolboxAndroid/star"
      class="minibutton with-count js-toggler-target star-button unstarred"
      aria-label="Star this repository" title="Star whatnot15/CleanAndSoberToolboxAndroid" data-remote="true" data-method="post" rel="nofollow">
      <span class="octicon octicon-star"></span><span class="text">Star</span>
    </a>

      <a class="social-count js-social-count" href="/whatnot15/CleanAndSoberToolboxAndroid/stargazers">
        0
      </a>
  </div>

  </li>


        <li>
          <a href="/whatnot15/CleanAndSoberToolboxAndroid/fork" class="minibutton with-count js-toggler-target fork-button lighter tooltipped-n" title="Fork your own copy of whatnot15/CleanAndSoberToolboxAndroid to your account" aria-label="Fork your own copy of whatnot15/CleanAndSoberToolboxAndroid to your account" rel="facebox nofollow">
            <span class="octicon octicon-git-branch-create"></span><span class="text">Fork</span>
          </a>
          <a href="/whatnot15/CleanAndSoberToolboxAndroid/network" class="social-count">2</a>
        </li>


</ul>

        <h1 itemscope itemtype="http://data-vocabulary.org/Breadcrumb" class="entry-title public">
          <span class="repo-label"><span>public</span></span>
          <span class="mega-octicon octicon-repo"></span>
          <span class="author">
            <a href="/whatnot15" class="url fn" itemprop="url" rel="author"><span itemprop="title">whatnot15</span></a>
          </span>
          <span class="repohead-name-divider">/</span>
          <strong><a href="/whatnot15/CleanAndSoberToolboxAndroid" class="js-current-repository js-repo-home-link">CleanAndSoberToolboxAndroid</a></strong>

          <span class="page-context-loader">
            <img alt="Octocat-spinner-32" height="16" src="https://github.global.ssl.fastly.net/images/spinners/octocat-spinner-32.gif" width="16" />
          </span>

        </h1>
      </div><!-- /.container -->
    </div><!-- /.repohead -->

    <div class="container">
      <div class="repository-with-sidebar repo-container new-discussion-timeline js-new-discussion-timeline  ">
        <div class="repository-sidebar clearfix">
            

<div class="sunken-menu vertical-right repo-nav js-repo-nav js-repository-container-pjax js-octicon-loaders">
  <div class="sunken-menu-contents">
    <ul class="sunken-menu-group">
      <li class="tooltipped tooltipped-w" aria-label="Code">
        <a href="/whatnot15/CleanAndSoberToolboxAndroid" aria-label="Code" class="selected js-selected-navigation-item sunken-menu-item" data-gotokey="c" data-pjax="true" data-selected-links="repo_source repo_downloads repo_commits repo_tags repo_branches /whatnot15/CleanAndSoberToolboxAndroid">
          <span class="octicon octicon-code"></span> <span class="full-word">Code</span>
          <img alt="Octocat-spinner-32" class="mini-loader" height="16" src="https://github.global.ssl.fastly.net/images/spinners/octocat-spinner-32.gif" width="16" />
</a>      </li>

        <li class="tooltipped tooltipped-w" aria-label="Issues">
          <a href="/whatnot15/CleanAndSoberToolboxAndroid/issues" aria-label="Issues" class="js-selected-navigation-item sunken-menu-item js-disable-pjax" data-gotokey="i" data-selected-links="repo_issues /whatnot15/CleanAndSoberToolboxAndroid/issues">
            <span class="octicon octicon-issue-opened"></span> <span class="full-word">Issues</span>
            <span class='counter'>0</span>
            <img alt="Octocat-spinner-32" class="mini-loader" height="16" src="https://github.global.ssl.fastly.net/images/spinners/octocat-spinner-32.gif" width="16" />
</a>        </li>

      <li class="tooltipped tooltipped-w" aria-label="Pull Requests">
        <a href="/whatnot15/CleanAndSoberToolboxAndroid/pulls" aria-label="Pull Requests" class="js-selected-navigation-item sunken-menu-item js-disable-pjax" data-gotokey="p" data-selected-links="repo_pulls /whatnot15/CleanAndSoberToolboxAndroid/pulls">
            <span class="octicon octicon-git-pull-request"></span> <span class="full-word">Pull Requests</span>
            <span class='counter'>0</span>
            <img alt="Octocat-spinner-32" class="mini-loader" height="16" src="https://github.global.ssl.fastly.net/images/spinners/octocat-spinner-32.gif" width="16" />
</a>      </li>


        <li class="tooltipped tooltipped-w" aria-label="Wiki">
          <a href="/whatnot15/CleanAndSoberToolboxAndroid/wiki" aria-label="Wiki" class="js-selected-navigation-item sunken-menu-item" data-pjax="true" data-selected-links="repo_wiki /whatnot15/CleanAndSoberToolboxAndroid/wiki">
            <span class="octicon octicon-book"></span> <span class="full-word">Wiki</span>
            <img alt="Octocat-spinner-32" class="mini-loader" height="16" src="https://github.global.ssl.fastly.net/images/spinners/octocat-spinner-32.gif" width="16" />
</a>        </li>
    </ul>
    <div class="sunken-menu-separator"></div>
    <ul class="sunken-menu-group">

      <li class="tooltipped tooltipped-w" aria-label="Pulse">
        <a href="/whatnot15/CleanAndSoberToolboxAndroid/pulse" aria-label="Pulse" class="js-selected-navigation-item sunken-menu-item" data-pjax="true" data-selected-links="pulse /whatnot15/CleanAndSoberToolboxAndroid/pulse">
          <span class="octicon octicon-pulse"></span> <span class="full-word">Pulse</span>
          <img alt="Octocat-spinner-32" class="mini-loader" height="16" src="https://github.global.ssl.fastly.net/images/spinners/octocat-spinner-32.gif" width="16" />
</a>      </li>

      <li class="tooltipped tooltipped-w" aria-label="Graphs">
        <a href="/whatnot15/CleanAndSoberToolboxAndroid/graphs" aria-label="Graphs" class="js-selected-navigation-item sunken-menu-item" data-pjax="true" data-selected-links="repo_graphs repo_contributors /whatnot15/CleanAndSoberToolboxAndroid/graphs">
          <span class="octicon octicon-graph"></span> <span class="full-word">Graphs</span>
          <img alt="Octocat-spinner-32" class="mini-loader" height="16" src="https://github.global.ssl.fastly.net/images/spinners/octocat-spinner-32.gif" width="16" />
</a>      </li>

      <li class="tooltipped tooltipped-w" aria-label="Network">
        <a href="/whatnot15/CleanAndSoberToolboxAndroid/network" aria-label="Network" class="js-selected-navigation-item sunken-menu-item js-disable-pjax" data-selected-links="repo_network /whatnot15/CleanAndSoberToolboxAndroid/network">
          <span class="octicon octicon-git-branch"></span> <span class="full-word">Network</span>
          <img alt="Octocat-spinner-32" class="mini-loader" height="16" src="https://github.global.ssl.fastly.net/images/spinners/octocat-spinner-32.gif" width="16" />
</a>      </li>
    </ul>


  </div>
</div>

              <div class="only-with-full-nav">
                

  

<div class="clone-url open"
  data-protocol-type="http"
  data-url="/users/set_protocol?protocol_selector=http&amp;protocol_type=push">
  <h3><strong>HTTPS</strong> clone URL</h3>
  <div class="clone-url-box">
    <input type="text" class="clone js-url-field"
           value="https://github.com/whatnot15/CleanAndSoberToolboxAndroid.git" readonly="readonly">

    <span aria-label="copy to clipboard" class="js-zeroclipboard url-box-clippy minibutton zeroclipboard-button" data-clipboard-text="https://github.com/whatnot15/CleanAndSoberToolboxAndroid.git" data-copied-hint="copied!"><span class="octicon octicon-clippy"></span></span>
  </div>
</div>

  

<div class="clone-url "
  data-protocol-type="ssh"
  data-url="/users/set_protocol?protocol_selector=ssh&amp;protocol_type=push">
  <h3><strong>SSH</strong> clone URL</h3>
  <div class="clone-url-box">
    <input type="text" class="clone js-url-field"
           value="git@github.com:whatnot15/CleanAndSoberToolboxAndroid.git" readonly="readonly">

    <span aria-label="copy to clipboard" class="js-zeroclipboard url-box-clippy minibutton zeroclipboard-button" data-clipboard-text="git@github.com:whatnot15/CleanAndSoberToolboxAndroid.git" data-copied-hint="copied!"><span class="octicon octicon-clippy"></span></span>
  </div>
</div>

  

<div class="clone-url "
  data-protocol-type="subversion"
  data-url="/users/set_protocol?protocol_selector=subversion&amp;protocol_type=push">
  <h3><strong>Subversion</strong> checkout URL</h3>
  <div class="clone-url-box">
    <input type="text" class="clone js-url-field"
           value="https://github.com/whatnot15/CleanAndSoberToolboxAndroid" readonly="readonly">

    <span aria-label="copy to clipboard" class="js-zeroclipboard url-box-clippy minibutton zeroclipboard-button" data-clipboard-text="https://github.com/whatnot15/CleanAndSoberToolboxAndroid" data-copied-hint="copied!"><span class="octicon octicon-clippy"></span></span>
  </div>
</div>


<p class="clone-options">You can clone with
      <a href="#" class="js-clone-selector" data-protocol="http">HTTPS</a>,
      <a href="#" class="js-clone-selector" data-protocol="ssh">SSH</a>,
      or <a href="#" class="js-clone-selector" data-protocol="subversion">Subversion</a>.
  <span class="help tooltipped tooltipped-n" aria-label="Get help on which URL is right for you.">
    <a href="https://help.github.com/articles/which-remote-url-should-i-use">
    <span class="octicon octicon-question"></span>
    </a>
  </span>
</p>


  <a href="github-windows://openRepo/https://github.com/whatnot15/CleanAndSoberToolboxAndroid" class="minibutton sidebar-button" title="Save whatnot15/CleanAndSoberToolboxAndroid to your computer and use it in GitHub Desktop." aria-label="Save whatnot15/CleanAndSoberToolboxAndroid to your computer and use it in GitHub Desktop.">
    <span class="octicon octicon-device-desktop"></span>
    Clone in Desktop
  </a>

                <a href="/whatnot15/CleanAndSoberToolboxAndroid/archive/master.zip"
                   class="minibutton sidebar-button"
                   aria-label="Download whatnot15/CleanAndSoberToolboxAndroid as a zip file"
                   title="Download whatnot15/CleanAndSoberToolboxAndroid as a zip file"
                   rel="nofollow">
                  <span class="octicon octicon-cloud-download"></span>
                  Download ZIP
                </a>
              </div>
        </div><!-- /.repository-sidebar -->

        <div id="js-repo-pjax-container" class="repository-content context-loader-container" data-pjax-container>
          


<!-- blob contrib key: blob_contributors:v21:e735e8f48455be1daa99525a0ecd185a -->

<p title="This is a placeholder element" class="js-history-link-replace hidden"></p>

<a href="/whatnot15/CleanAndSoberToolboxAndroid/find/master" data-pjax data-hotkey="t" class="js-show-file-finder" style="display:none">Show File Finder</a>

<div class="file-navigation">
  

<div class="select-menu js-menu-container js-select-menu" >
  <span class="minibutton select-menu-button js-menu-target" data-hotkey="w"
    data-master-branch="master"
    data-ref="master"
    role="button" aria-label="Switch branches or tags" tabindex="0" aria-haspopup="true">
    <span class="octicon octicon-git-branch"></span>
    <i>branch:</i>
    <span class="js-select-button">master</span>
  </span>

  <div class="select-menu-modal-holder js-menu-content js-navigation-container" data-pjax aria-hidden="true">

    <div class="select-menu-modal">
      <div class="select-menu-header">
        <span class="select-menu-title">Switch branches/tags</span>
        <span class="octicon octicon-remove-close js-menu-close"></span>
      </div> <!-- /.select-menu-header -->

      <div class="select-menu-filters">
        <div class="select-menu-text-filter">
          <input type="text" aria-label="Find or create a branch…" id="context-commitish-filter-field" class="js-filterable-field js-navigation-enable" placeholder="Find or create a branch…">
        </div>
        <div class="select-menu-tabs">
          <ul>
            <li class="select-menu-tab">
              <a href="#" data-tab-filter="branches" class="js-select-menu-tab">Branches</a>
            </li>
            <li class="select-menu-tab">
              <a href="#" data-tab-filter="tags" class="js-select-menu-tab">Tags</a>
            </li>
          </ul>
        </div><!-- /.select-menu-tabs -->
      </div><!-- /.select-menu-filters -->

      <div class="select-menu-list select-menu-tab-bucket js-select-menu-tab-bucket" data-tab-filter="branches">

        <div data-filterable-for="context-commitish-filter-field" data-filterable-type="substring">


            <div class="select-menu-item js-navigation-item selected">
              <span class="select-menu-item-icon octicon octicon-check"></span>
              <a href="/whatnot15/CleanAndSoberToolboxAndroid/blob/master/App/src/com/osu/cleanandsobertoolboxandroid/MainActivity.java"
                 data-name="master"
                 data-skip-pjax="true"
                 rel="nofollow"
                 class="js-navigation-open select-menu-item-text js-select-button-text css-truncate-target"
                 title="master">master</a>
            </div> <!-- /.select-menu-item -->
        </div>

          <form accept-charset="UTF-8" action="/whatnot15/CleanAndSoberToolboxAndroid/branches" class="js-create-branch select-menu-item select-menu-new-item-form js-navigation-item js-new-item-form" method="post"><div style="margin:0;padding:0;display:inline"><input name="authenticity_token" type="hidden" value="XqkUeWgF2ybro1T9GMKT3PgHeaP8L5F+AC94fIHpYBU=" /></div>
            <span class="octicon octicon-git-branch-create select-menu-item-icon"></span>
            <div class="select-menu-item-text">
              <h4>Create branch: <span class="js-new-item-name"></span></h4>
              <span class="description">from ‘master’</span>
            </div>
            <input type="hidden" name="name" id="name" class="js-new-item-value">
            <input type="hidden" name="branch" id="branch" value="master" />
            <input type="hidden" name="path" id="path" value="App/src/com/osu/cleanandsobertoolboxandroid/MainActivity.java" />
          </form> <!-- /.select-menu-item -->

      </div> <!-- /.select-menu-list -->

      <div class="select-menu-list select-menu-tab-bucket js-select-menu-tab-bucket" data-tab-filter="tags">
        <div data-filterable-for="context-commitish-filter-field" data-filterable-type="substring">


        </div>

        <div class="select-menu-no-results">Nothing to show</div>
      </div> <!-- /.select-menu-list -->

    </div> <!-- /.select-menu-modal -->
  </div> <!-- /.select-menu-modal-holder -->
</div> <!-- /.select-menu -->

  <div class="breadcrumb">
    <span class='repo-root js-repo-root'><span itemscope="" itemtype="http://data-vocabulary.org/Breadcrumb"><a href="/whatnot15/CleanAndSoberToolboxAndroid" data-branch="master" data-direction="back" data-pjax="true" itemscope="url"><span itemprop="title">CleanAndSoberToolboxAndroid</span></a></span></span><span class="separator"> / </span><span itemscope="" itemtype="http://data-vocabulary.org/Breadcrumb"><a href="/whatnot15/CleanAndSoberToolboxAndroid/tree/master/App" data-branch="master" data-direction="back" data-pjax="true" itemscope="url"><span itemprop="title">App</span></a></span><span class="separator"> / </span><span itemscope="" itemtype="http://data-vocabulary.org/Breadcrumb"><a href="/whatnot15/CleanAndSoberToolboxAndroid/tree/master/App/src" data-branch="master" data-direction="back" data-pjax="true" itemscope="url"><span itemprop="title">src</span></a></span><span class="separator"> / </span><span itemscope="" itemtype="http://data-vocabulary.org/Breadcrumb"><a href="/whatnot15/CleanAndSoberToolboxAndroid/tree/master/App/src/com" data-branch="master" data-direction="back" data-pjax="true" itemscope="url"><span itemprop="title">com</span></a></span><span class="separator"> / </span><span itemscope="" itemtype="http://data-vocabulary.org/Breadcrumb"><a href="/whatnot15/CleanAndSoberToolboxAndroid/tree/master/App/src/com/osu" data-branch="master" data-direction="back" data-pjax="true" itemscope="url"><span itemprop="title">osu</span></a></span><span class="separator"> / </span><span itemscope="" itemtype="http://data-vocabulary.org/Breadcrumb"><a href="/whatnot15/CleanAndSoberToolboxAndroid/tree/master/App/src/com/osu/cleanandsobertoolboxandroid" data-branch="master" data-direction="back" data-pjax="true" itemscope="url"><span itemprop="title">cleanandsobertoolboxandroid</span></a></span><span class="separator"> / </span><strong class="final-path">MainActivity.java</strong> <span aria-label="copy to clipboard" class="js-zeroclipboard minibutton zeroclipboard-button" data-clipboard-text="App/src/com/osu/cleanandsobertoolboxandroid/MainActivity.java" data-copied-hint="copied!"><span class="octicon octicon-clippy"></span></span>
  </div>
</div>


  <div class="commit file-history-tease">
    <img alt="whatnot15" class="main-avatar js-avatar" data-user="5564880" height="24" src="https://avatars1.githubusercontent.com/u/5564880?s=140" width="24" />
    <span class="author"><a href="/whatnot15" rel="author">whatnot15</a></span>
    <time class="js-relative-date" data-title-format="YYYY-MM-DD HH:mm:ss" datetime="2014-03-28T19:15:03-04:00" title="2014-03-28 19:15:03">March 28, 2014</time>
    <div class="commit-title">
        <a href="/whatnot15/CleanAndSoberToolboxAndroid/commit/ce20938a0476b966a64b70f76d800674854e7b91" class="message" data-pjax="true" title="Updated Main Activity

Now tracks day user has used app. Variable &quot;days&quot; inside MainActivity
keeps track of this.">Updated Main Activity</a>
    </div>

    <div class="participation">
      <p class="quickstat"><a href="#blob_contributors_box" rel="facebox"><strong>2</strong>  contributors</a></p>
          <a class="avatar tooltipped tooltipped-s" aria-label="whatnot15" href="/whatnot15/CleanAndSoberToolboxAndroid/commits/master/App/src/com/osu/cleanandsobertoolboxandroid/MainActivity.java?author=whatnot15"><img alt="whatnot15" class=" js-avatar" data-user="5564880" height="20" src="https://avatars1.githubusercontent.com/u/5564880?s=140" width="20" /></a>
    <a class="avatar tooltipped tooltipped-s" aria-label="vikramwakade" href="/whatnot15/CleanAndSoberToolboxAndroid/commits/master/App/src/com/osu/cleanandsobertoolboxandroid/MainActivity.java?author=vikramwakade"><img alt="vikramwakade" class=" js-avatar" data-user="3997931" height="20" src="https://avatars1.githubusercontent.com/u/3997931?s=140" width="20" /></a>


    </div>
    <div id="blob_contributors_box" style="display:none">
      <h2 class="facebox-header">Users who have contributed to this file</h2>
      <ul class="facebox-user-list">
          <li class="facebox-user-list-item">
            <img alt="whatnot15" class=" js-avatar" data-user="5564880" height="24" src="https://avatars1.githubusercontent.com/u/5564880?s=140" width="24" />
            <a href="/whatnot15">whatnot15</a>
          </li>
          <li class="facebox-user-list-item">
            <img alt="vikramwakade" class=" js-avatar" data-user="3997931" height="24" src="https://avatars1.githubusercontent.com/u/3997931?s=140" width="24" />
            <a href="/vikramwakade">vikramwakade</a>
          </li>
      </ul>
    </div>
  </div>

<div class="file-box">
  <div class="file">
    <div class="meta clearfix">
      <div class="info file-name">
        <span class="icon"><b class="octicon octicon-file-text"></b></span>
        <span class="mode" title="File Mode">file</span>
        <span class="meta-divider"></span>
          <span>384 lines (300 sloc)</span>
          <span class="meta-divider"></span>
        <span>13.313 kb</span>
      </div>
      <div class="actions">
        <div class="button-group">
            <a class="minibutton tooltipped tooltipped-w"
               href="github-windows://openRepo/https://github.com/whatnot15/CleanAndSoberToolboxAndroid?branch=master&amp;filepath=App%2Fsrc%2Fcom%2Fosu%2Fcleanandsobertoolboxandroid%2FMainActivity.java" aria-label="Open this file in GitHub for Windows">
                <span class="octicon octicon-device-desktop"></span> Open
            </a>
                <a class="minibutton js-update-url-with-hash"
                   href="/whatnot15/CleanAndSoberToolboxAndroid/edit/master/App/src/com/osu/cleanandsobertoolboxandroid/MainActivity.java"
                   data-method="post" rel="nofollow" data-hotkey="e">Edit</a>
          <a href="/whatnot15/CleanAndSoberToolboxAndroid/raw/master/App/src/com/osu/cleanandsobertoolboxandroid/MainActivity.java" class="button minibutton " id="raw-url">Raw</a>
            <a href="/whatnot15/CleanAndSoberToolboxAndroid/blame/master/App/src/com/osu/cleanandsobertoolboxandroid/MainActivity.java" class="button minibutton js-update-url-with-hash">Blame</a>
          <a href="/whatnot15/CleanAndSoberToolboxAndroid/commits/master/App/src/com/osu/cleanandsobertoolboxandroid/MainActivity.java" class="button minibutton " rel="nofollow">History</a>
        </div><!-- /.button-group -->

            <a class="minibutton danger empty-icon"
               href="/whatnot15/CleanAndSoberToolboxAndroid/delete/master/App/src/com/osu/cleanandsobertoolboxandroid/MainActivity.java"
               data-method="post" data-test-id="delete-blob-file" rel="nofollow">

          Delete
        </a>
      </div><!-- /.actions -->
    </div>
        <div class="blob-wrapper data type-java js-blob-data">
        <table class="file-code file-diff tab-size-8">
          <tr class="file-code-line">
            <td class="blob-line-nums">
              <span id="L1" rel="#L1">1</span>
<span id="L2" rel="#L2">2</span>
<span id="L3" rel="#L3">3</span>
<span id="L4" rel="#L4">4</span>
<span id="L5" rel="#L5">5</span>
<span id="L6" rel="#L6">6</span>
<span id="L7" rel="#L7">7</span>
<span id="L8" rel="#L8">8</span>
<span id="L9" rel="#L9">9</span>
<span id="L10" rel="#L10">10</span>
<span id="L11" rel="#L11">11</span>
<span id="L12" rel="#L12">12</span>
<span id="L13" rel="#L13">13</span>
<span id="L14" rel="#L14">14</span>
<span id="L15" rel="#L15">15</span>
<span id="L16" rel="#L16">16</span>
<span id="L17" rel="#L17">17</span>
<span id="L18" rel="#L18">18</span>
<span id="L19" rel="#L19">19</span>
<span id="L20" rel="#L20">20</span>
<span id="L21" rel="#L21">21</span>
<span id="L22" rel="#L22">22</span>
<span id="L23" rel="#L23">23</span>
<span id="L24" rel="#L24">24</span>
<span id="L25" rel="#L25">25</span>
<span id="L26" rel="#L26">26</span>
<span id="L27" rel="#L27">27</span>
<span id="L28" rel="#L28">28</span>
<span id="L29" rel="#L29">29</span>
<span id="L30" rel="#L30">30</span>
<span id="L31" rel="#L31">31</span>
<span id="L32" rel="#L32">32</span>
<span id="L33" rel="#L33">33</span>
<span id="L34" rel="#L34">34</span>
<span id="L35" rel="#L35">35</span>
<span id="L36" rel="#L36">36</span>
<span id="L37" rel="#L37">37</span>
<span id="L38" rel="#L38">38</span>
<span id="L39" rel="#L39">39</span>
<span id="L40" rel="#L40">40</span>
<span id="L41" rel="#L41">41</span>
<span id="L42" rel="#L42">42</span>
<span id="L43" rel="#L43">43</span>
<span id="L44" rel="#L44">44</span>
<span id="L45" rel="#L45">45</span>
<span id="L46" rel="#L46">46</span>
<span id="L47" rel="#L47">47</span>
<span id="L48" rel="#L48">48</span>
<span id="L49" rel="#L49">49</span>
<span id="L50" rel="#L50">50</span>
<span id="L51" rel="#L51">51</span>
<span id="L52" rel="#L52">52</span>
<span id="L53" rel="#L53">53</span>
<span id="L54" rel="#L54">54</span>
<span id="L55" rel="#L55">55</span>
<span id="L56" rel="#L56">56</span>
<span id="L57" rel="#L57">57</span>
<span id="L58" rel="#L58">58</span>
<span id="L59" rel="#L59">59</span>
<span id="L60" rel="#L60">60</span>
<span id="L61" rel="#L61">61</span>
<span id="L62" rel="#L62">62</span>
<span id="L63" rel="#L63">63</span>
<span id="L64" rel="#L64">64</span>
<span id="L65" rel="#L65">65</span>
<span id="L66" rel="#L66">66</span>
<span id="L67" rel="#L67">67</span>
<span id="L68" rel="#L68">68</span>
<span id="L69" rel="#L69">69</span>
<span id="L70" rel="#L70">70</span>
<span id="L71" rel="#L71">71</span>
<span id="L72" rel="#L72">72</span>
<span id="L73" rel="#L73">73</span>
<span id="L74" rel="#L74">74</span>
<span id="L75" rel="#L75">75</span>
<span id="L76" rel="#L76">76</span>
<span id="L77" rel="#L77">77</span>
<span id="L78" rel="#L78">78</span>
<span id="L79" rel="#L79">79</span>
<span id="L80" rel="#L80">80</span>
<span id="L81" rel="#L81">81</span>
<span id="L82" rel="#L82">82</span>
<span id="L83" rel="#L83">83</span>
<span id="L84" rel="#L84">84</span>
<span id="L85" rel="#L85">85</span>
<span id="L86" rel="#L86">86</span>
<span id="L87" rel="#L87">87</span>
<span id="L88" rel="#L88">88</span>
<span id="L89" rel="#L89">89</span>
<span id="L90" rel="#L90">90</span>
<span id="L91" rel="#L91">91</span>
<span id="L92" rel="#L92">92</span>
<span id="L93" rel="#L93">93</span>
<span id="L94" rel="#L94">94</span>
<span id="L95" rel="#L95">95</span>
<span id="L96" rel="#L96">96</span>
<span id="L97" rel="#L97">97</span>
<span id="L98" rel="#L98">98</span>
<span id="L99" rel="#L99">99</span>
<span id="L100" rel="#L100">100</span>
<span id="L101" rel="#L101">101</span>
<span id="L102" rel="#L102">102</span>
<span id="L103" rel="#L103">103</span>
<span id="L104" rel="#L104">104</span>
<span id="L105" rel="#L105">105</span>
<span id="L106" rel="#L106">106</span>
<span id="L107" rel="#L107">107</span>
<span id="L108" rel="#L108">108</span>
<span id="L109" rel="#L109">109</span>
<span id="L110" rel="#L110">110</span>
<span id="L111" rel="#L111">111</span>
<span id="L112" rel="#L112">112</span>
<span id="L113" rel="#L113">113</span>
<span id="L114" rel="#L114">114</span>
<span id="L115" rel="#L115">115</span>
<span id="L116" rel="#L116">116</span>
<span id="L117" rel="#L117">117</span>
<span id="L118" rel="#L118">118</span>
<span id="L119" rel="#L119">119</span>
<span id="L120" rel="#L120">120</span>
<span id="L121" rel="#L121">121</span>
<span id="L122" rel="#L122">122</span>
<span id="L123" rel="#L123">123</span>
<span id="L124" rel="#L124">124</span>
<span id="L125" rel="#L125">125</span>
<span id="L126" rel="#L126">126</span>
<span id="L127" rel="#L127">127</span>
<span id="L128" rel="#L128">128</span>
<span id="L129" rel="#L129">129</span>
<span id="L130" rel="#L130">130</span>
<span id="L131" rel="#L131">131</span>
<span id="L132" rel="#L132">132</span>
<span id="L133" rel="#L133">133</span>
<span id="L134" rel="#L134">134</span>
<span id="L135" rel="#L135">135</span>
<span id="L136" rel="#L136">136</span>
<span id="L137" rel="#L137">137</span>
<span id="L138" rel="#L138">138</span>
<span id="L139" rel="#L139">139</span>
<span id="L140" rel="#L140">140</span>
<span id="L141" rel="#L141">141</span>
<span id="L142" rel="#L142">142</span>
<span id="L143" rel="#L143">143</span>
<span id="L144" rel="#L144">144</span>
<span id="L145" rel="#L145">145</span>
<span id="L146" rel="#L146">146</span>
<span id="L147" rel="#L147">147</span>
<span id="L148" rel="#L148">148</span>
<span id="L149" rel="#L149">149</span>
<span id="L150" rel="#L150">150</span>
<span id="L151" rel="#L151">151</span>
<span id="L152" rel="#L152">152</span>
<span id="L153" rel="#L153">153</span>
<span id="L154" rel="#L154">154</span>
<span id="L155" rel="#L155">155</span>
<span id="L156" rel="#L156">156</span>
<span id="L157" rel="#L157">157</span>
<span id="L158" rel="#L158">158</span>
<span id="L159" rel="#L159">159</span>
<span id="L160" rel="#L160">160</span>
<span id="L161" rel="#L161">161</span>
<span id="L162" rel="#L162">162</span>
<span id="L163" rel="#L163">163</span>
<span id="L164" rel="#L164">164</span>
<span id="L165" rel="#L165">165</span>
<span id="L166" rel="#L166">166</span>
<span id="L167" rel="#L167">167</span>
<span id="L168" rel="#L168">168</span>
<span id="L169" rel="#L169">169</span>
<span id="L170" rel="#L170">170</span>
<span id="L171" rel="#L171">171</span>
<span id="L172" rel="#L172">172</span>
<span id="L173" rel="#L173">173</span>
<span id="L174" rel="#L174">174</span>
<span id="L175" rel="#L175">175</span>
<span id="L176" rel="#L176">176</span>
<span id="L177" rel="#L177">177</span>
<span id="L178" rel="#L178">178</span>
<span id="L179" rel="#L179">179</span>
<span id="L180" rel="#L180">180</span>
<span id="L181" rel="#L181">181</span>
<span id="L182" rel="#L182">182</span>
<span id="L183" rel="#L183">183</span>
<span id="L184" rel="#L184">184</span>
<span id="L185" rel="#L185">185</span>
<span id="L186" rel="#L186">186</span>
<span id="L187" rel="#L187">187</span>
<span id="L188" rel="#L188">188</span>
<span id="L189" rel="#L189">189</span>
<span id="L190" rel="#L190">190</span>
<span id="L191" rel="#L191">191</span>
<span id="L192" rel="#L192">192</span>
<span id="L193" rel="#L193">193</span>
<span id="L194" rel="#L194">194</span>
<span id="L195" rel="#L195">195</span>
<span id="L196" rel="#L196">196</span>
<span id="L197" rel="#L197">197</span>
<span id="L198" rel="#L198">198</span>
<span id="L199" rel="#L199">199</span>
<span id="L200" rel="#L200">200</span>
<span id="L201" rel="#L201">201</span>
<span id="L202" rel="#L202">202</span>
<span id="L203" rel="#L203">203</span>
<span id="L204" rel="#L204">204</span>
<span id="L205" rel="#L205">205</span>
<span id="L206" rel="#L206">206</span>
<span id="L207" rel="#L207">207</span>
<span id="L208" rel="#L208">208</span>
<span id="L209" rel="#L209">209</span>
<span id="L210" rel="#L210">210</span>
<span id="L211" rel="#L211">211</span>
<span id="L212" rel="#L212">212</span>
<span id="L213" rel="#L213">213</span>
<span id="L214" rel="#L214">214</span>
<span id="L215" rel="#L215">215</span>
<span id="L216" rel="#L216">216</span>
<span id="L217" rel="#L217">217</span>
<span id="L218" rel="#L218">218</span>
<span id="L219" rel="#L219">219</span>
<span id="L220" rel="#L220">220</span>
<span id="L221" rel="#L221">221</span>
<span id="L222" rel="#L222">222</span>
<span id="L223" rel="#L223">223</span>
<span id="L224" rel="#L224">224</span>
<span id="L225" rel="#L225">225</span>
<span id="L226" rel="#L226">226</span>
<span id="L227" rel="#L227">227</span>
<span id="L228" rel="#L228">228</span>
<span id="L229" rel="#L229">229</span>
<span id="L230" rel="#L230">230</span>
<span id="L231" rel="#L231">231</span>
<span id="L232" rel="#L232">232</span>
<span id="L233" rel="#L233">233</span>
<span id="L234" rel="#L234">234</span>
<span id="L235" rel="#L235">235</span>
<span id="L236" rel="#L236">236</span>
<span id="L237" rel="#L237">237</span>
<span id="L238" rel="#L238">238</span>
<span id="L239" rel="#L239">239</span>
<span id="L240" rel="#L240">240</span>
<span id="L241" rel="#L241">241</span>
<span id="L242" rel="#L242">242</span>
<span id="L243" rel="#L243">243</span>
<span id="L244" rel="#L244">244</span>
<span id="L245" rel="#L245">245</span>
<span id="L246" rel="#L246">246</span>
<span id="L247" rel="#L247">247</span>
<span id="L248" rel="#L248">248</span>
<span id="L249" rel="#L249">249</span>
<span id="L250" rel="#L250">250</span>
<span id="L251" rel="#L251">251</span>
<span id="L252" rel="#L252">252</span>
<span id="L253" rel="#L253">253</span>
<span id="L254" rel="#L254">254</span>
<span id="L255" rel="#L255">255</span>
<span id="L256" rel="#L256">256</span>
<span id="L257" rel="#L257">257</span>
<span id="L258" rel="#L258">258</span>
<span id="L259" rel="#L259">259</span>
<span id="L260" rel="#L260">260</span>
<span id="L261" rel="#L261">261</span>
<span id="L262" rel="#L262">262</span>
<span id="L263" rel="#L263">263</span>
<span id="L264" rel="#L264">264</span>
<span id="L265" rel="#L265">265</span>
<span id="L266" rel="#L266">266</span>
<span id="L267" rel="#L267">267</span>
<span id="L268" rel="#L268">268</span>
<span id="L269" rel="#L269">269</span>
<span id="L270" rel="#L270">270</span>
<span id="L271" rel="#L271">271</span>
<span id="L272" rel="#L272">272</span>
<span id="L273" rel="#L273">273</span>
<span id="L274" rel="#L274">274</span>
<span id="L275" rel="#L275">275</span>
<span id="L276" rel="#L276">276</span>
<span id="L277" rel="#L277">277</span>
<span id="L278" rel="#L278">278</span>
<span id="L279" rel="#L279">279</span>
<span id="L280" rel="#L280">280</span>
<span id="L281" rel="#L281">281</span>
<span id="L282" rel="#L282">282</span>
<span id="L283" rel="#L283">283</span>
<span id="L284" rel="#L284">284</span>
<span id="L285" rel="#L285">285</span>
<span id="L286" rel="#L286">286</span>
<span id="L287" rel="#L287">287</span>
<span id="L288" rel="#L288">288</span>
<span id="L289" rel="#L289">289</span>
<span id="L290" rel="#L290">290</span>
<span id="L291" rel="#L291">291</span>
<span id="L292" rel="#L292">292</span>
<span id="L293" rel="#L293">293</span>
<span id="L294" rel="#L294">294</span>
<span id="L295" rel="#L295">295</span>
<span id="L296" rel="#L296">296</span>
<span id="L297" rel="#L297">297</span>
<span id="L298" rel="#L298">298</span>
<span id="L299" rel="#L299">299</span>
<span id="L300" rel="#L300">300</span>
<span id="L301" rel="#L301">301</span>
<span id="L302" rel="#L302">302</span>
<span id="L303" rel="#L303">303</span>
<span id="L304" rel="#L304">304</span>
<span id="L305" rel="#L305">305</span>
<span id="L306" rel="#L306">306</span>
<span id="L307" rel="#L307">307</span>
<span id="L308" rel="#L308">308</span>
<span id="L309" rel="#L309">309</span>
<span id="L310" rel="#L310">310</span>
<span id="L311" rel="#L311">311</span>
<span id="L312" rel="#L312">312</span>
<span id="L313" rel="#L313">313</span>
<span id="L314" rel="#L314">314</span>
<span id="L315" rel="#L315">315</span>
<span id="L316" rel="#L316">316</span>
<span id="L317" rel="#L317">317</span>
<span id="L318" rel="#L318">318</span>
<span id="L319" rel="#L319">319</span>
<span id="L320" rel="#L320">320</span>
<span id="L321" rel="#L321">321</span>
<span id="L322" rel="#L322">322</span>
<span id="L323" rel="#L323">323</span>
<span id="L324" rel="#L324">324</span>
<span id="L325" rel="#L325">325</span>
<span id="L326" rel="#L326">326</span>
<span id="L327" rel="#L327">327</span>
<span id="L328" rel="#L328">328</span>
<span id="L329" rel="#L329">329</span>
<span id="L330" rel="#L330">330</span>
<span id="L331" rel="#L331">331</span>
<span id="L332" rel="#L332">332</span>
<span id="L333" rel="#L333">333</span>
<span id="L334" rel="#L334">334</span>
<span id="L335" rel="#L335">335</span>
<span id="L336" rel="#L336">336</span>
<span id="L337" rel="#L337">337</span>
<span id="L338" rel="#L338">338</span>
<span id="L339" rel="#L339">339</span>
<span id="L340" rel="#L340">340</span>
<span id="L341" rel="#L341">341</span>
<span id="L342" rel="#L342">342</span>
<span id="L343" rel="#L343">343</span>
<span id="L344" rel="#L344">344</span>
<span id="L345" rel="#L345">345</span>
<span id="L346" rel="#L346">346</span>
<span id="L347" rel="#L347">347</span>
<span id="L348" rel="#L348">348</span>
<span id="L349" rel="#L349">349</span>
<span id="L350" rel="#L350">350</span>
<span id="L351" rel="#L351">351</span>
<span id="L352" rel="#L352">352</span>
<span id="L353" rel="#L353">353</span>
<span id="L354" rel="#L354">354</span>
<span id="L355" rel="#L355">355</span>
<span id="L356" rel="#L356">356</span>
<span id="L357" rel="#L357">357</span>
<span id="L358" rel="#L358">358</span>
<span id="L359" rel="#L359">359</span>
<span id="L360" rel="#L360">360</span>
<span id="L361" rel="#L361">361</span>
<span id="L362" rel="#L362">362</span>
<span id="L363" rel="#L363">363</span>
<span id="L364" rel="#L364">364</span>
<span id="L365" rel="#L365">365</span>
<span id="L366" rel="#L366">366</span>
<span id="L367" rel="#L367">367</span>
<span id="L368" rel="#L368">368</span>
<span id="L369" rel="#L369">369</span>
<span id="L370" rel="#L370">370</span>
<span id="L371" rel="#L371">371</span>
<span id="L372" rel="#L372">372</span>
<span id="L373" rel="#L373">373</span>
<span id="L374" rel="#L374">374</span>
<span id="L375" rel="#L375">375</span>
<span id="L376" rel="#L376">376</span>
<span id="L377" rel="#L377">377</span>
<span id="L378" rel="#L378">378</span>
<span id="L379" rel="#L379">379</span>
<span id="L380" rel="#L380">380</span>
<span id="L381" rel="#L381">381</span>
<span id="L382" rel="#L382">382</span>
<span id="L383" rel="#L383">383</span>

            </td>
            <td class="blob-line-code"><div class="code-body highlight"><pre><div class='line' id='LC1'><span class="kn">package</span> <span class="n">com</span><span class="o">.</span><span class="na">osu</span><span class="o">.</span><span class="na">cleanandsobertoolboxandroid</span><span class="o">;</span></div><div class='line' id='LC2'><br/></div><div class='line' id='LC3'><span class="kn">import</span> <span class="nn">java.util.Calendar</span><span class="o">;</span></div><div class='line' id='LC4'><span class="kn">import</span> <span class="nn">java.util.Date</span><span class="o">;</span></div><div class='line' id='LC5'><span class="kn">import</span> <span class="nn">java.util.Locale</span><span class="o">;</span></div><div class='line' id='LC6'><span class="kn">import</span> <span class="nn">java.text.DateFormat</span><span class="o">;</span></div><div class='line' id='LC7'><span class="kn">import</span> <span class="nn">java.text.ParseException</span><span class="o">;</span></div><div class='line' id='LC8'><span class="kn">import</span> <span class="nn">java.text.SimpleDateFormat</span><span class="o">;</span></div><div class='line' id='LC9'><br/></div><div class='line' id='LC10'><br/></div><div class='line' id='LC11'><span class="kn">import</span> <span class="nn">android.app.SearchManager</span><span class="o">;</span></div><div class='line' id='LC12'><span class="kn">import</span> <span class="nn">android.content.Context</span><span class="o">;</span></div><div class='line' id='LC13'><span class="kn">import</span> <span class="nn">android.content.SharedPreferences</span><span class="o">;</span></div><div class='line' id='LC14'><span class="kn">import</span> <span class="nn">android.content.res.Configuration</span><span class="o">;</span></div><div class='line' id='LC15'><span class="kn">import</span> <span class="nn">android.os.Bundle</span><span class="o">;</span></div><div class='line' id='LC16'><span class="kn">import</span> <span class="nn">android.support.v4.app.ActionBarDrawerToggle</span><span class="o">;</span></div><div class='line' id='LC17'><span class="kn">import</span> <span class="nn">android.support.v4.app.FragmentActivity</span><span class="o">;</span></div><div class='line' id='LC18'><span class="kn">import</span> <span class="nn">android.support.v4.app.FragmentTransaction</span><span class="o">;</span></div><div class='line' id='LC19'><span class="kn">import</span> <span class="nn">android.support.v4.widget.DrawerLayout</span><span class="o">;</span></div><div class='line' id='LC20'><span class="kn">import</span> <span class="nn">android.telephony.TelephonyManager</span><span class="o">;</span></div><div class='line' id='LC21'><span class="kn">import</span> <span class="nn">android.util.Log</span><span class="o">;</span></div><div class='line' id='LC22'><span class="kn">import</span> <span class="nn">android.view.Menu</span><span class="o">;</span></div><div class='line' id='LC23'><span class="kn">import</span> <span class="nn">android.view.MenuInflater</span><span class="o">;</span></div><div class='line' id='LC24'><span class="kn">import</span> <span class="nn">android.view.MenuItem</span><span class="o">;</span></div><div class='line' id='LC25'><span class="kn">import</span> <span class="nn">android.view.View</span><span class="o">;</span></div><div class='line' id='LC26'><span class="kn">import</span> <span class="nn">android.widget.AdapterView</span><span class="o">;</span></div><div class='line' id='LC27'><span class="kn">import</span> <span class="nn">android.widget.ArrayAdapter</span><span class="o">;</span></div><div class='line' id='LC28'><span class="kn">import</span> <span class="nn">android.widget.LinearLayout</span><span class="o">;</span></div><div class='line' id='LC29'><span class="kn">import</span> <span class="nn">android.widget.ListView</span><span class="o">;</span></div><div class='line' id='LC30'><span class="kn">import</span> <span class="nn">android.widget.SearchView</span><span class="o">;</span></div><div class='line' id='LC31'><br/></div><div class='line' id='LC32'><br/></div><div class='line' id='LC33'><span class="kn">import</span> <span class="nn">com.google.android.gms.ads.AdRequest</span><span class="o">;</span></div><div class='line' id='LC34'><span class="kn">import</span> <span class="nn">com.google.android.gms.ads.AdSize</span><span class="o">;</span></div><div class='line' id='LC35'><span class="kn">import</span> <span class="nn">com.google.android.gms.ads.AdView</span><span class="o">;</span></div><div class='line' id='LC36'><br/></div><div class='line' id='LC37'><span class="kd">public</span> <span class="kd">class</span> <span class="nc">MainActivity</span> <span class="kd">extends</span> <span class="n">FragmentActivity</span> </div><div class='line' id='LC38'>	<span class="kd">implements</span> <span class="cm">/*TopicsFragment.OnTopicSelectedListener,</span></div><div class='line' id='LC39'><span class="cm">			   SubCategoryFragment.OnSubCategorySelectedListener,*/</span></div><div class='line' id='LC40'>			   <span class="n">CategoryFragment</span><span class="o">.</span><span class="na">OnCategorySelectedListner</span> <span class="o">{</span></div><div class='line' id='LC41'><br/></div><div class='line' id='LC42'>	<span class="n">SharedPreferences</span> <span class="n">prefs</span> <span class="o">=</span> <span class="kc">null</span><span class="o">;</span></div><div class='line' id='LC43'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">private</span> <span class="n">ActionBarDrawerToggle</span> <span class="n">mDrawerToggle</span><span class="o">;</span></div><div class='line' id='LC44'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">private</span> <span class="n">ListView</span> <span class="n">mDrawerList</span><span class="o">;</span></div><div class='line' id='LC45'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">private</span> <span class="n">DrawerLayout</span> <span class="n">mDrawerLayout</span><span class="o">;</span></div><div class='line' id='LC46'>&nbsp;&nbsp;&nbsp;&nbsp;</div><div class='line' id='LC47'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">private</span> <span class="n">CharSequence</span> <span class="n">mDrawerTitle</span><span class="o">;</span></div><div class='line' id='LC48'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">private</span> <span class="n">CharSequence</span> <span class="n">mTitle</span><span class="o">;</span></div><div class='line' id='LC49'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">public</span> <span class="kt">int</span> <span class="n">days</span> <span class="o">=</span> <span class="mi">1</span><span class="o">;</span></div><div class='line' id='LC50'>&nbsp;&nbsp;&nbsp;&nbsp;</div><div class='line' id='LC51'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/** The view to show the ad. */</span></div><div class='line' id='LC52'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">private</span> <span class="n">AdView</span> <span class="n">adView</span><span class="o">;</span></div><div class='line' id='LC53'>&nbsp;</div><div class='line' id='LC54'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* Your ad unit id. Replace with your actual ad unit id. */</span></div><div class='line' id='LC55'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">private</span> <span class="kd">static</span> <span class="kd">final</span> <span class="n">String</span> <span class="n">AD_UNIT_ID</span> <span class="o">=</span> <span class="s">&quot;INSERT_YOUR_AD_UNIT_ID_HERE&quot;</span><span class="o">;</span></div><div class='line' id='LC56'>&nbsp;&nbsp;&nbsp;&nbsp;</div><div class='line' id='LC57'>	<span class="nd">@Override</span></div><div class='line' id='LC58'>	<span class="kd">protected</span> <span class="kt">void</span> <span class="nf">onCreate</span><span class="o">(</span><span class="n">Bundle</span> <span class="n">savedInstanceState</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC59'>		<span class="kd">super</span><span class="o">.</span><span class="na">onCreate</span><span class="o">(</span><span class="n">savedInstanceState</span><span class="o">);</span></div><div class='line' id='LC60'>		<span class="n">setContentView</span><span class="o">(</span><span class="n">R</span><span class="o">.</span><span class="na">layout</span><span class="o">.</span><span class="na">all_categories</span><span class="o">);</span></div><div class='line' id='LC61'><br/></div><div class='line' id='LC62'><br/></div><div class='line' id='LC63'><br/></div><div class='line' id='LC64'>		 <span class="c1">// Create an ad.</span></div><div class='line' id='LC65'>	    <span class="n">adView</span> <span class="o">=</span> <span class="k">new</span> <span class="n">AdView</span><span class="o">(</span><span class="k">this</span><span class="o">);</span></div><div class='line' id='LC66'>	    <span class="n">adView</span><span class="o">.</span><span class="na">setAdSize</span><span class="o">(</span><span class="n">AdSize</span><span class="o">.</span><span class="na">BANNER</span><span class="o">);</span></div><div class='line' id='LC67'>	    <span class="n">adView</span><span class="o">.</span><span class="na">setAdUnitId</span><span class="o">(</span><span class="s">&quot;0445b7141d9d4e1b&quot;</span><span class="o">);</span></div><div class='line' id='LC68'><br/></div><div class='line' id='LC69'>	 <span class="c1">// Add the AdView to the view hierarchy. The view will have no size</span></div><div class='line' id='LC70'>	    <span class="c1">// until the ad is loaded.</span></div><div class='line' id='LC71'>	    <span class="n">LinearLayout</span> <span class="n">layout</span> <span class="o">=</span> <span class="o">(</span><span class="n">LinearLayout</span><span class="o">)</span> <span class="n">findViewById</span><span class="o">(</span><span class="n">R</span><span class="o">.</span><span class="na">id</span><span class="o">.</span><span class="na">linearlayout</span><span class="o">);</span></div><div class='line' id='LC72'>	    <span class="n">layout</span><span class="o">.</span><span class="na">addView</span><span class="o">(</span><span class="n">adView</span><span class="o">);</span></div><div class='line' id='LC73'><br/></div><div class='line' id='LC74'>	    <span class="kd">final</span> <span class="n">TelephonyManager</span> <span class="n">tm</span> <span class="o">=(</span><span class="n">TelephonyManager</span><span class="o">)</span><span class="n">getBaseContext</span><span class="o">().</span><span class="na">getSystemService</span><span class="o">(</span><span class="n">Context</span><span class="o">.</span><span class="na">TELEPHONY_SERVICE</span><span class="o">);</span></div><div class='line' id='LC75'><br/></div><div class='line' id='LC76'>	    <span class="n">String</span> <span class="n">deviceid</span> <span class="o">=</span> <span class="n">tm</span><span class="o">.</span><span class="na">getDeviceId</span><span class="o">();</span></div><div class='line' id='LC77'><br/></div><div class='line' id='LC78'>	 <span class="c1">// Create an ad request. Check logcat output for the hashed device ID to</span></div><div class='line' id='LC79'>	    <span class="c1">// get test ads on a physical device.</span></div><div class='line' id='LC80'>	    <span class="n">AdRequest</span> <span class="n">adRequest</span> <span class="o">=</span> <span class="k">new</span> <span class="n">AdRequest</span><span class="o">.</span><span class="na">Builder</span><span class="o">()</span></div><div class='line' id='LC81'>	        <span class="o">.</span><span class="na">addTestDevice</span><span class="o">(</span><span class="n">AdRequest</span><span class="o">.</span><span class="na">DEVICE_ID_EMULATOR</span><span class="o">)</span></div><div class='line' id='LC82'>	        <span class="o">.</span><span class="na">addTestDevice</span><span class="o">(</span><span class="n">deviceid</span><span class="o">)</span></div><div class='line' id='LC83'>	        <span class="o">.</span><span class="na">build</span><span class="o">();</span></div><div class='line' id='LC84'><br/></div><div class='line' id='LC85'>	    <span class="c1">// Start loading the ad in the background.</span></div><div class='line' id='LC86'>	    <span class="n">adView</span><span class="o">.</span><span class="na">loadAd</span><span class="o">(</span><span class="n">adRequest</span><span class="o">);</span></div><div class='line' id='LC87'><br/></div><div class='line' id='LC88'>		<span class="n">mTitle</span> <span class="o">=</span> <span class="n">mDrawerTitle</span> <span class="o">=</span> <span class="n">getTitle</span><span class="o">();</span></div><div class='line' id='LC89'>		<span class="c1">//Log.i(&quot;INFO&quot;,mPlanetTitles[0]);</span></div><div class='line' id='LC90'>		<span class="c1">// Creating an ArrayAdapter to add items to the listview mDrawerList</span></div><div class='line' id='LC91'>		<span class="n">ArrayAdapter</span><span class="o">&lt;</span><span class="n">String</span><span class="o">&gt;</span> <span class="n">adapter</span> <span class="o">=</span> <span class="k">new</span> <span class="n">ArrayAdapter</span><span class="o">&lt;</span><span class="n">String</span><span class="o">&gt;(</span><span class="n">getBaseContext</span><span class="o">(),</span> </div><div class='line' id='LC92'>		        <span class="n">R</span><span class="o">.</span><span class="na">layout</span><span class="o">.</span><span class="na">drawer_list_item</span><span class="o">,</span> <span class="n">getResources</span><span class="o">().</span><span class="na">getStringArray</span><span class="o">(</span><span class="n">R</span><span class="o">.</span><span class="na">array</span><span class="o">.</span><span class="na">drawer_array</span><span class="o">));</span></div><div class='line' id='LC93'><br/></div><div class='line' id='LC94'><br/></div><div class='line' id='LC95'>		<span class="n">mDrawerLayout</span> <span class="o">=</span> <span class="o">(</span><span class="n">DrawerLayout</span><span class="o">)</span> <span class="n">findViewById</span><span class="o">(</span><span class="n">R</span><span class="o">.</span><span class="na">id</span><span class="o">.</span><span class="na">drawer_layout</span><span class="o">);</span></div><div class='line' id='LC96'>		<span class="n">mDrawerList</span> <span class="o">=</span> <span class="o">(</span><span class="n">ListView</span><span class="o">)</span> <span class="n">findViewById</span><span class="o">(</span><span class="n">R</span><span class="o">.</span><span class="na">id</span><span class="o">.</span><span class="na">drawer_list</span><span class="o">);</span></div><div class='line' id='LC97'><br/></div><div class='line' id='LC98'>		<span class="n">mDrawerList</span><span class="o">.</span><span class="na">setAdapter</span><span class="o">(</span><span class="n">adapter</span><span class="o">);</span></div><div class='line' id='LC99'>		<span class="c1">// Set the list&#39;s click listener</span></div><div class='line' id='LC100'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">mDrawerList</span><span class="o">.</span><span class="na">setOnItemClickListener</span><span class="o">(</span><span class="k">new</span> <span class="n">DrawerItemClickListener</span><span class="o">());</span>		</div><div class='line' id='LC101'>&nbsp;</div><div class='line' id='LC102'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="c1">// enable ActionBar app icon to behave as action to toggle nav drawer</span></div><div class='line' id='LC103'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">getActionBar</span><span class="o">().</span><span class="na">setDisplayHomeAsUpEnabled</span><span class="o">(</span><span class="kc">true</span><span class="o">);</span></div><div class='line' id='LC104'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">getActionBar</span><span class="o">().</span><span class="na">setHomeButtonEnabled</span><span class="o">(</span><span class="kc">true</span><span class="o">);</span></div><div class='line' id='LC105'><br/></div><div class='line' id='LC106'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">mDrawerToggle</span> <span class="o">=</span> <span class="k">new</span> <span class="n">ActionBarDrawerToggle</span><span class="o">(</span></div><div class='line' id='LC107'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">this</span><span class="o">,</span>                  <span class="cm">/* host Activity */</span></div><div class='line' id='LC108'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">mDrawerLayout</span><span class="o">,</span>         <span class="cm">/* DrawerLayout object */</span></div><div class='line' id='LC109'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">R</span><span class="o">.</span><span class="na">drawable</span><span class="o">.</span><span class="na">ic_drawer</span><span class="o">,</span>  <span class="cm">/* nav drawer image to replace &#39;Up&#39; caret */</span></div><div class='line' id='LC110'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">R</span><span class="o">.</span><span class="na">string</span><span class="o">.</span><span class="na">drawer_open</span><span class="o">,</span>  <span class="cm">/* &quot;open drawer&quot; description for accessibility */</span></div><div class='line' id='LC111'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">R</span><span class="o">.</span><span class="na">string</span><span class="o">.</span><span class="na">drawer_close</span>  <span class="cm">/* &quot;close drawer&quot; description for accessibility */</span></div><div class='line' id='LC112'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC113'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">public</span> <span class="kt">void</span> <span class="nf">onDrawerClosed</span><span class="o">(</span><span class="n">View</span> <span class="n">view</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC114'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">getActionBar</span><span class="o">().</span><span class="na">setTitle</span><span class="o">(</span><span class="n">mTitle</span><span class="o">);</span></div><div class='line' id='LC115'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">invalidateOptionsMenu</span><span class="o">();</span> <span class="c1">// creates call to onPrepareOptionsMenu()</span></div><div class='line' id='LC116'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span></div><div class='line' id='LC117'><br/></div><div class='line' id='LC118'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">public</span> <span class="kt">void</span> <span class="nf">onDrawerOpened</span><span class="o">(</span><span class="n">View</span> <span class="n">drawerView</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC119'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">getActionBar</span><span class="o">().</span><span class="na">setTitle</span><span class="o">(</span><span class="s">&quot;Days Sober: &quot;</span> <span class="o">+</span> <span class="n">days</span><span class="o">);</span><span class="c1">//(mDrawerTitle);</span></div><div class='line' id='LC120'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">invalidateOptionsMenu</span><span class="o">();</span> <span class="c1">// creates call to onPrepareOptionsMenu()</span></div><div class='line' id='LC121'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span></div><div class='line' id='LC122'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">};</span></div><div class='line' id='LC123'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div><div class='line' id='LC124'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">mDrawerLayout</span><span class="o">.</span><span class="na">setDrawerListener</span><span class="o">(</span><span class="n">mDrawerToggle</span><span class="o">);</span></div><div class='line' id='LC125'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div><div class='line' id='LC126'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="c1">// Code to create the database when run for the first time</span></div><div class='line' id='LC127'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="c1">// and then populate the tables with data read from json file</span></div><div class='line' id='LC128'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="o">(!</span><span class="n">MessageDataSource</span><span class="o">.</span><span class="na">databaseExist</span><span class="o">(</span><span class="k">this</span><span class="o">,</span> <span class="n">MessageReaderDbHelper</span><span class="o">.</span><span class="na">DATABASE_NAME</span><span class="o">))</span></div><div class='line' id='LC129'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">{</span></div><div class='line' id='LC130'>	        <span class="n">MessageDataSource</span> <span class="n">ds</span> <span class="o">=</span> <span class="k">new</span> <span class="n">MessageDataSource</span><span class="o">(</span><span class="k">this</span><span class="o">);</span></div><div class='line' id='LC131'>	        <span class="n">ds</span><span class="o">.</span><span class="na">open</span><span class="o">();</span></div><div class='line' id='LC132'>	        <span class="c1">//ds.EmptyDb();</span></div><div class='line' id='LC133'>	        <span class="n">String</span> <span class="n">result</span> <span class="o">=</span> <span class="n">ds</span><span class="o">.</span><span class="na">ProcessJSONFile</span><span class="o">(</span><span class="n">R</span><span class="o">.</span><span class="na">raw</span><span class="o">.</span><span class="na">newest_cleaned_data</span><span class="o">);</span></div><div class='line' id='LC134'>	        <span class="n">ds</span><span class="o">.</span><span class="na">PopulateDbFromJSON</span><span class="o">(</span><span class="n">result</span><span class="o">);</span></div><div class='line' id='LC135'>	        <span class="n">ds</span><span class="o">.</span><span class="na">close</span><span class="o">();</span></div><div class='line' id='LC136'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span></div><div class='line' id='LC137'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div><div class='line' id='LC138'>		<span class="n">CategoryFragment</span> <span class="n">firstFragment</span> <span class="o">=</span> <span class="k">new</span> <span class="n">CategoryFragment</span><span class="o">();</span></div><div class='line' id='LC139'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div><div class='line' id='LC140'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="c1">// This is the top level fragment, so pass -1 as the parent</span></div><div class='line' id='LC141'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="c1">// id, since it has no parent category</span></div><div class='line' id='LC142'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">Bundle</span> <span class="n">args</span> <span class="o">=</span> <span class="k">new</span> <span class="n">Bundle</span><span class="o">();</span></div><div class='line' id='LC143'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">args</span><span class="o">.</span><span class="na">putInt</span><span class="o">(</span><span class="n">CategoryFragment</span><span class="o">.</span><span class="na">PARENT_ID</span><span class="o">,</span> <span class="o">-</span><span class="mi">1</span><span class="o">);</span></div><div class='line' id='LC144'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">firstFragment</span><span class="o">.</span><span class="na">setArguments</span><span class="o">(</span><span class="n">args</span><span class="o">);</span></div><div class='line' id='LC145'><br/></div><div class='line' id='LC146'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="c1">// Add the fragment to the &#39;fragment_container&#39; FrameLayout</span></div><div class='line' id='LC147'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">getSupportFragmentManager</span><span class="o">().</span><span class="na">beginTransaction</span><span class="o">()</span></div><div class='line' id='LC148'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">.</span><span class="na">add</span><span class="o">(</span><span class="n">R</span><span class="o">.</span><span class="na">id</span><span class="o">.</span><span class="na">content_frame</span><span class="o">,</span> <span class="n">firstFragment</span><span class="o">).</span><span class="na">commit</span><span class="o">();</span></div><div class='line' id='LC149'>	<span class="o">}</span></div><div class='line' id='LC150'><br/></div><div class='line' id='LC151'>	 <span class="nd">@Override</span></div><div class='line' id='LC152'>	  <span class="kd">public</span> <span class="kt">void</span> <span class="nf">onResume</span><span class="o">()</span> <span class="o">{</span></div><div class='line' id='LC153'>	    <span class="kd">super</span><span class="o">.</span><span class="na">onResume</span><span class="o">();</span></div><div class='line' id='LC154'>	    <span class="k">if</span> <span class="o">(</span><span class="n">adView</span> <span class="o">!=</span> <span class="kc">null</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC155'>	      <span class="n">adView</span><span class="o">.</span><span class="na">resume</span><span class="o">();</span></div><div class='line' id='LC156'>	    <span class="o">}</span></div><div class='line' id='LC157'><br/></div><div class='line' id='LC158'>	  <span class="c1">//Get prefs</span></div><div class='line' id='LC159'>	    <span class="n">prefs</span> <span class="o">=</span> <span class="n">getSharedPreferences</span><span class="o">(</span><span class="s">&quot;com.osu.cleanandsobertoolboxaround&quot;</span><span class="o">,</span> <span class="n">MODE_PRIVATE</span><span class="o">);</span></div><div class='line' id='LC160'>	 <span class="c1">// Create an instance of SimpleDateFormat used for formatting </span></div><div class='line' id='LC161'>	 <span class="c1">// the string representation of date (month/day/year)</span></div><div class='line' id='LC162'>	 	<span class="n">DateFormat</span> <span class="n">df</span> <span class="o">=</span> <span class="k">new</span> <span class="n">SimpleDateFormat</span><span class="o">(</span><span class="s">&quot;MM/dd/yyyy HH:mm:ss&quot;</span><span class="o">,</span> <span class="n">Locale</span><span class="o">.</span><span class="na">US</span><span class="o">);</span></div><div class='line' id='LC163'>	 <span class="c1">//Check if this is the first time the app is run</span></div><div class='line' id='LC164'>	 	<span class="k">if</span> <span class="o">(</span><span class="n">prefs</span><span class="o">.</span><span class="na">getBoolean</span><span class="o">(</span><span class="s">&quot;firstrun&quot;</span><span class="o">,</span> <span class="kc">true</span><span class="o">)</span> <span class="o">==</span> <span class="kc">true</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC165'><br/></div><div class='line' id='LC166'>	 		<span class="c1">// Get the date today using Calendar object.</span></div><div class='line' id='LC167'>	 		<span class="n">Date</span> <span class="n">today</span> <span class="o">=</span> <span class="n">Calendar</span><span class="o">.</span><span class="na">getInstance</span><span class="o">().</span><span class="na">getTime</span><span class="o">();</span>  </div><div class='line' id='LC168'><br/></div><div class='line' id='LC169'>	 		<span class="n">String</span> <span class="n">todaysDate</span> <span class="o">=</span> <span class="n">df</span><span class="o">.</span><span class="na">format</span><span class="o">(</span><span class="n">today</span><span class="o">);</span></div><div class='line' id='LC170'><br/></div><div class='line' id='LC171'>	 		<span class="c1">//Set prefs for this being first date app is used</span></div><div class='line' id='LC172'>	 		<span class="n">prefs</span><span class="o">.</span><span class="na">edit</span><span class="o">().</span><span class="na">putString</span><span class="o">(</span><span class="s">&quot;LAST_USED&quot;</span><span class="o">,</span> <span class="n">todaysDate</span><span class="o">).</span><span class="na">commit</span><span class="o">();</span></div><div class='line' id='LC173'>	 	    <span class="n">prefs</span><span class="o">.</span><span class="na">edit</span><span class="o">().</span><span class="na">putBoolean</span><span class="o">(</span><span class="s">&quot;firstrun&quot;</span><span class="o">,</span> <span class="kc">false</span><span class="o">).</span><span class="na">commit</span><span class="o">();</span></div><div class='line' id='LC174'>	 	 <span class="o">}</span></div><div class='line' id='LC175'>	 	 <span class="k">else</span><span class="o">{</span></div><div class='line' id='LC176'>	 		 <span class="c1">//Check how many days it has been since last use</span></div><div class='line' id='LC177'><br/></div><div class='line' id='LC178'>	 		 <span class="c1">//Get pref value</span></div><div class='line' id='LC179'>	 		 <span class="n">String</span> <span class="n">lastDate</span> <span class="o">=</span> <span class="n">prefs</span><span class="o">.</span><span class="na">getString</span><span class="o">(</span><span class="s">&quot;LAST_USED&quot;</span><span class="o">,</span> <span class="s">&quot;This shouldn&#39;t happen&quot;</span><span class="o">);</span></div><div class='line' id='LC180'>	 		 <span class="c1">//Find today&#39;s date</span></div><div class='line' id='LC181'>	 		 <span class="n">Date</span> <span class="n">today</span> <span class="o">=</span> <span class="n">Calendar</span><span class="o">.</span><span class="na">getInstance</span><span class="o">().</span><span class="na">getTime</span><span class="o">();</span>  </div><div class='line' id='LC182'>	 		 <span class="c1">//Convert to a string</span></div><div class='line' id='LC183'>	 		 <span class="n">String</span> <span class="n">todaysDate</span> <span class="o">=</span> <span class="n">df</span><span class="o">.</span><span class="na">format</span><span class="o">(</span><span class="n">today</span><span class="o">);</span></div><div class='line' id='LC184'><br/></div><div class='line' id='LC185'>	 		 <span class="c1">//Change day to int</span></div><div class='line' id='LC186'>	 		 <span class="kt">int</span> <span class="n">todayday</span> <span class="o">=</span> <span class="n">Integer</span><span class="o">.</span><span class="na">parseInt</span><span class="o">(</span><span class="n">todaysDate</span><span class="o">.</span><span class="na">substring</span><span class="o">(</span><span class="mi">3</span><span class="o">,</span><span class="mi">5</span><span class="o">));</span></div><div class='line' id='LC187'><br/></div><div class='line' id='LC188'>	 		 <span class="kt">int</span> <span class="n">lastday</span> <span class="o">=</span> <span class="n">Integer</span><span class="o">.</span><span class="na">parseInt</span><span class="o">(</span><span class="n">lastDate</span><span class="o">.</span><span class="na">substring</span><span class="o">(</span><span class="mi">3</span><span class="o">,</span><span class="mi">5</span><span class="o">));</span></div><div class='line' id='LC189'><br/></div><div class='line' id='LC190'>	 		 <span class="k">if</span> <span class="o">(</span><span class="n">todayday</span> <span class="o">!=</span> <span class="n">lastday</span><span class="o">){</span></div><div class='line' id='LC191'>	 			<span class="c1">//Different day, add a day to user&#39;s time</span></div><div class='line' id='LC192'>	 			<span class="n">days</span><span class="o">++;</span></div><div class='line' id='LC193'><br/></div><div class='line' id='LC194'>	 			<span class="c1">//Change date for prefs</span></div><div class='line' id='LC195'>	 			<span class="n">prefs</span><span class="o">.</span><span class="na">edit</span><span class="o">().</span><span class="na">putString</span><span class="o">(</span><span class="s">&quot;LAST_USED&quot;</span><span class="o">,</span> <span class="n">df</span><span class="o">.</span><span class="na">format</span><span class="o">(</span><span class="n">todaysDate</span><span class="o">)).</span><span class="na">commit</span><span class="o">();</span></div><div class='line' id='LC196'>	 		 <span class="o">}</span></div><div class='line' id='LC197'><br/></div><div class='line' id='LC198'>	 		 <span class="k">else</span><span class="o">{</span></div><div class='line' id='LC199'>	 		 <span class="c1">//Check months/years just in case user hasn&#39;t used for a month or a year exactly</span></div><div class='line' id='LC200'>	 			 <span class="kt">int</span> <span class="n">todaymonth</span> <span class="o">=</span> <span class="n">Integer</span><span class="o">.</span><span class="na">parseInt</span><span class="o">(</span><span class="n">todaysDate</span><span class="o">.</span><span class="na">substring</span><span class="o">(</span><span class="mi">0</span><span class="o">,</span><span class="mi">2</span><span class="o">));</span></div><div class='line' id='LC201'><br/></div><div class='line' id='LC202'>	 			 <span class="kt">int</span> <span class="n">lastmonth</span> <span class="o">=</span> <span class="n">Integer</span><span class="o">.</span><span class="na">parseInt</span><span class="o">(</span><span class="n">lastDate</span><span class="o">.</span><span class="na">substring</span><span class="o">(</span><span class="mi">0</span><span class="o">,</span><span class="mi">2</span><span class="o">));</span></div><div class='line' id='LC203'><br/></div><div class='line' id='LC204'>	 			 <span class="kt">int</span> <span class="n">todayyear</span> <span class="o">=</span> <span class="n">Integer</span><span class="o">.</span><span class="na">parseInt</span><span class="o">(</span><span class="n">todaysDate</span><span class="o">.</span><span class="na">substring</span><span class="o">(</span><span class="mi">6</span><span class="o">,</span><span class="mi">10</span><span class="o">));</span></div><div class='line' id='LC205'><br/></div><div class='line' id='LC206'>	 			 <span class="kt">int</span> <span class="n">lastyear</span> <span class="o">=</span> <span class="n">Integer</span><span class="o">.</span><span class="na">parseInt</span><span class="o">(</span><span class="n">lastDate</span><span class="o">.</span><span class="na">substring</span><span class="o">(</span><span class="mi">6</span><span class="o">,</span><span class="mi">10</span><span class="o">));</span></div><div class='line' id='LC207'><br/></div><div class='line' id='LC208'>	 			 <span class="k">if</span> <span class="o">((</span><span class="n">todaymonth</span> <span class="o">!=</span> <span class="n">lastmonth</span><span class="o">)</span> <span class="o">||</span> <span class="o">(</span><span class="n">todayyear</span> <span class="o">!=</span> <span class="n">lastyear</span><span class="o">)){</span></div><div class='line' id='LC209'>	 				<span class="c1">//Same day but different month or year, add a day</span></div><div class='line' id='LC210'>	 				 <span class="n">days</span><span class="o">++;</span></div><div class='line' id='LC211'><br/></div><div class='line' id='LC212'>	 				<span class="c1">//Change date for prefs</span></div><div class='line' id='LC213'>	 				 <span class="n">prefs</span><span class="o">.</span><span class="na">edit</span><span class="o">().</span><span class="na">putString</span><span class="o">(</span><span class="s">&quot;LAST_USED&quot;</span><span class="o">,</span> <span class="n">df</span><span class="o">.</span><span class="na">format</span><span class="o">(</span><span class="n">todaysDate</span><span class="o">)).</span><span class="na">commit</span><span class="o">();</span></div><div class='line' id='LC214'>	 			<span class="o">}</span></div><div class='line' id='LC215'>	 			<span class="o">}</span></div><div class='line' id='LC216'><br/></div><div class='line' id='LC217'>	 		    <span class="o">}</span></div><div class='line' id='LC218'>	  <span class="o">}</span></div><div class='line' id='LC219'><br/></div><div class='line' id='LC220'>	  <span class="nd">@Override</span></div><div class='line' id='LC221'>	  <span class="kd">public</span> <span class="kt">void</span> <span class="nf">onPause</span><span class="o">()</span> <span class="o">{</span></div><div class='line' id='LC222'>	    <span class="k">if</span> <span class="o">(</span><span class="n">adView</span> <span class="o">!=</span> <span class="kc">null</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC223'>	      <span class="n">adView</span><span class="o">.</span><span class="na">pause</span><span class="o">();</span></div><div class='line' id='LC224'>	    <span class="o">}</span></div><div class='line' id='LC225'>	    <span class="kd">super</span><span class="o">.</span><span class="na">onPause</span><span class="o">();</span></div><div class='line' id='LC226'>	  <span class="o">}</span></div><div class='line' id='LC227'><br/></div><div class='line' id='LC228'><br/></div><div class='line' id='LC229'>	  <span class="cm">/** Called before the activity is destroyed. */</span></div><div class='line' id='LC230'>	  <span class="nd">@Override</span></div><div class='line' id='LC231'>	  <span class="kd">public</span> <span class="kt">void</span> <span class="nf">onDestroy</span><span class="o">()</span> <span class="o">{</span></div><div class='line' id='LC232'>	    <span class="c1">// Destroy the AdView.</span></div><div class='line' id='LC233'>	    <span class="k">if</span> <span class="o">(</span><span class="n">adView</span> <span class="o">!=</span> <span class="kc">null</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC234'>	      <span class="n">adView</span><span class="o">.</span><span class="na">destroy</span><span class="o">();</span></div><div class='line' id='LC235'>	    <span class="o">}</span></div><div class='line' id='LC236'>	    <span class="kd">super</span><span class="o">.</span><span class="na">onDestroy</span><span class="o">();</span></div><div class='line' id='LC237'>	  <span class="o">}</span></div><div class='line' id='LC238'><br/></div><div class='line' id='LC239'>	<span class="cm">/* Called whenever we call invalidateOptionsMenu() */</span></div><div class='line' id='LC240'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="nd">@Override</span></div><div class='line' id='LC241'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">public</span> <span class="kt">boolean</span> <span class="nf">onPrepareOptionsMenu</span><span class="o">(</span><span class="n">Menu</span> <span class="n">menu</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC242'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="c1">// If the nav drawer is open, hide action items related to the content view</span></div><div class='line' id='LC243'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="kd">super</span><span class="o">.</span><span class="na">onPrepareOptionsMenu</span><span class="o">(</span><span class="n">menu</span><span class="o">);</span></div><div class='line' id='LC244'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span></div><div class='line' id='LC245'><br/></div><div class='line' id='LC246'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="nd">@Override</span></div><div class='line' id='LC247'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">public</span> <span class="kt">boolean</span> <span class="nf">onCreateOptionsMenu</span><span class="o">(</span><span class="n">Menu</span> <span class="n">menu</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC248'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">MenuInflater</span> <span class="n">inflater</span> <span class="o">=</span> <span class="n">getMenuInflater</span><span class="o">();</span></div><div class='line' id='LC249'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">inflater</span><span class="o">.</span><span class="na">inflate</span><span class="o">(</span><span class="n">R</span><span class="o">.</span><span class="na">menu</span><span class="o">.</span><span class="na">main</span><span class="o">,</span> <span class="n">menu</span><span class="o">);</span></div><div class='line' id='LC250'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div><div class='line' id='LC251'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="c1">//Associate searchable configuration with Searchview</span></div><div class='line' id='LC252'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">SearchManager</span> <span class="n">searchManager</span> <span class="o">=</span> <span class="o">(</span><span class="n">SearchManager</span><span class="o">)</span> <span class="n">getSystemService</span><span class="o">(</span><span class="n">Context</span><span class="o">.</span><span class="na">SEARCH_SERVICE</span><span class="o">);</span></div><div class='line' id='LC253'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">SearchView</span> <span class="n">searchView</span> <span class="o">=</span> <span class="o">(</span><span class="n">SearchView</span><span class="o">)</span> <span class="n">menu</span><span class="o">.</span><span class="na">findItem</span><span class="o">(</span><span class="n">R</span><span class="o">.</span><span class="na">id</span><span class="o">.</span><span class="na">search</span><span class="o">).</span><span class="na">getActionView</span><span class="o">();</span></div><div class='line' id='LC254'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">searchView</span><span class="o">.</span><span class="na">setSearchableInfo</span><span class="o">(</span><span class="n">searchManager</span><span class="o">.</span><span class="na">getSearchableInfo</span><span class="o">(</span><span class="n">getComponentName</span><span class="o">()));</span></div><div class='line' id='LC255'><br/></div><div class='line' id='LC256'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="kd">super</span><span class="o">.</span><span class="na">onCreateOptionsMenu</span><span class="o">(</span><span class="n">menu</span><span class="o">);</span></div><div class='line' id='LC257'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div><div class='line' id='LC258'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div><div class='line' id='LC259'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span></div><div class='line' id='LC260'><br/></div><div class='line' id='LC261'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* The click listener for ListView in the navigation drawer */</span></div><div class='line' id='LC262'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">private</span> <span class="kd">class</span> <span class="nc">DrawerItemClickListener</span> <span class="kd">implements</span> <span class="n">ListView</span><span class="o">.</span><span class="na">OnItemClickListener</span> <span class="o">{</span></div><div class='line' id='LC263'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nd">@Override</span></div><div class='line' id='LC264'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">public</span> <span class="kt">void</span> <span class="nf">onItemClick</span><span class="o">(</span><span class="n">AdapterView</span><span class="o">&lt;?&gt;</span> <span class="n">parent</span><span class="o">,</span> <span class="n">View</span> <span class="n">view</span><span class="o">,</span> <span class="kt">int</span> <span class="n">position</span><span class="o">,</span> <span class="kt">long</span> <span class="n">id</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC265'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">selectItem</span><span class="o">(</span><span class="n">position</span><span class="o">);</span></div><div class='line' id='LC266'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span></div><div class='line' id='LC267'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span></div><div class='line' id='LC268'><br/></div><div class='line' id='LC269'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">private</span> <span class="kt">void</span> <span class="nf">selectItem</span><span class="o">(</span><span class="kt">int</span> <span class="n">position</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC270'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="c1">//update the main content by replacing fragments</span></div><div class='line' id='LC271'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="c1">//TODO:</span></div><div class='line' id='LC272'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="c1">//mDrawerLayout.closeDrawer(mDrawerList);</span></div><div class='line' id='LC273'>&nbsp;&nbsp;&nbsp;&nbsp;	<span class="n">Log</span><span class="o">.</span><span class="na">i</span><span class="o">(</span><span class="s">&quot;Info&quot;</span><span class="o">,</span> <span class="s">&quot;&quot;</span><span class="o">+</span><span class="n">position</span><span class="o">);</span></div><div class='line' id='LC274'>&nbsp;&nbsp;&nbsp;&nbsp;	<span class="k">if</span> <span class="o">(</span><span class="n">position</span> <span class="o">==</span> <span class="n">NavigationMessageFragment</span><span class="o">.</span><span class="na">disclaimer</span> <span class="o">||</span> <span class="n">position</span> <span class="o">==</span> <span class="n">NavigationMessageFragment</span><span class="o">.</span><span class="na">psychology</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC275'>	    	<span class="n">NavigationMessageFragment</span> <span class="n">frag</span> <span class="o">=</span> <span class="k">new</span> <span class="n">NavigationMessageFragment</span><span class="o">();</span></div><div class='line' id='LC276'>	    	<span class="n">Bundle</span> <span class="n">args</span> <span class="o">=</span> <span class="k">new</span> <span class="n">Bundle</span><span class="o">();</span></div><div class='line' id='LC277'>	    	<span class="k">switch</span><span class="o">(</span><span class="n">position</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC278'><br/></div><div class='line' id='LC279'>	    	<span class="k">case</span> <span class="n">NavigationMessageFragment</span><span class="o">.</span><span class="na">disclaimer</span><span class="o">:</span></div><div class='line' id='LC280'><br/></div><div class='line' id='LC281'>	    		<span class="n">args</span><span class="o">.</span><span class="na">putInt</span><span class="o">(</span><span class="n">NavigationMessageFragment</span><span class="o">.</span><span class="na">DISCLAIMER</span><span class="o">,</span> <span class="mi">0</span><span class="o">);</span></div><div class='line' id='LC282'>	    	<span class="k">break</span><span class="o">;</span></div><div class='line' id='LC283'>	    	<span class="k">case</span> <span class="n">NavigationMessageFragment</span><span class="o">.</span><span class="na">psychology</span><span class="o">:</span></div><div class='line' id='LC284'>	    		<span class="n">args</span><span class="o">.</span><span class="na">putInt</span><span class="o">(</span><span class="n">NavigationMessageFragment</span><span class="o">.</span><span class="na">DISCLAIMER</span><span class="o">,</span> <span class="mi">1</span><span class="o">);</span></div><div class='line' id='LC285'>	    	<span class="k">break</span><span class="o">;</span></div><div class='line' id='LC286'>	    	<span class="k">default</span><span class="o">:</span></div><div class='line' id='LC287'>	    		<span class="k">break</span><span class="o">;</span></div><div class='line' id='LC288'>	    	<span class="o">}</span></div><div class='line' id='LC289'><br/></div><div class='line' id='LC290'>	    	<span class="n">frag</span><span class="o">.</span><span class="na">setArguments</span><span class="o">(</span><span class="n">args</span><span class="o">);</span></div><div class='line' id='LC291'><br/></div><div class='line' id='LC292'>	        <span class="n">FragmentTransaction</span> <span class="n">transaction</span> <span class="o">=</span> <span class="n">getSupportFragmentManager</span><span class="o">().</span><span class="na">beginTransaction</span><span class="o">();</span></div><div class='line' id='LC293'><br/></div><div class='line' id='LC294'>	        <span class="c1">// Replace whatever is in the fragment_container view with this fragment,</span></div><div class='line' id='LC295'>	        <span class="c1">// and add the transaction to the back stack so the user can navigate back</span></div><div class='line' id='LC296'>	        <span class="n">transaction</span><span class="o">.</span><span class="na">replace</span><span class="o">(</span><span class="n">R</span><span class="o">.</span><span class="na">id</span><span class="o">.</span><span class="na">content_frame</span><span class="o">,</span> <span class="n">frag</span><span class="o">);</span></div><div class='line' id='LC297'>	        <span class="n">transaction</span><span class="o">.</span><span class="na">addToBackStack</span><span class="o">(</span><span class="kc">null</span><span class="o">);</span></div><div class='line' id='LC298'><br/></div><div class='line' id='LC299'>	        <span class="c1">// Commit the transaction</span></div><div class='line' id='LC300'>	        <span class="n">transaction</span><span class="o">.</span><span class="na">commit</span><span class="o">();</span></div><div class='line' id='LC301'>&nbsp;&nbsp;&nbsp;&nbsp;	<span class="o">}</span></div><div class='line' id='LC302'>&nbsp;&nbsp;&nbsp;&nbsp;	<span class="k">else</span> <span class="nf">if</span><span class="o">(</span><span class="n">position</span> <span class="o">==</span> <span class="n">NotificationsFragment</span><span class="o">.</span><span class="na">POSITION</span><span class="o">)</span></div><div class='line' id='LC303'>&nbsp;&nbsp;&nbsp;&nbsp;	<span class="o">{</span></div><div class='line' id='LC304'>&nbsp;&nbsp;&nbsp;&nbsp;		<span class="n">NotificationsFragment</span> <span class="n">frag</span> <span class="o">=</span> <span class="k">new</span> <span class="n">NotificationsFragment</span><span class="o">();</span></div><div class='line' id='LC305'>&nbsp;&nbsp;&nbsp;&nbsp;		</div><div class='line' id='LC306'>&nbsp;&nbsp;&nbsp;&nbsp;		</div><div class='line' id='LC307'>&nbsp;&nbsp;&nbsp;&nbsp;		<span class="n">FragmentTransaction</span> <span class="n">transaction</span> <span class="o">=</span> <span class="n">getSupportFragmentManager</span><span class="o">().</span><span class="na">beginTransaction</span><span class="o">();</span></div><div class='line' id='LC308'>&nbsp;&nbsp;&nbsp;&nbsp;		</div><div class='line' id='LC309'>	        <span class="c1">// Replace whatever is in the fragment_container view with this fragment,</span></div><div class='line' id='LC310'>	        <span class="c1">// and add the transaction to the back stack so the user can navigate back</span></div><div class='line' id='LC311'>	        <span class="n">transaction</span><span class="o">.</span><span class="na">replace</span><span class="o">(</span><span class="n">R</span><span class="o">.</span><span class="na">id</span><span class="o">.</span><span class="na">content_frame</span><span class="o">,</span> <span class="n">frag</span><span class="o">);</span></div><div class='line' id='LC312'>	        <span class="n">transaction</span><span class="o">.</span><span class="na">addToBackStack</span><span class="o">(</span><span class="kc">null</span><span class="o">);</span></div><div class='line' id='LC313'><br/></div><div class='line' id='LC314'>	        <span class="c1">// Commit the transaction</span></div><div class='line' id='LC315'>	        <span class="n">transaction</span><span class="o">.</span><span class="na">commit</span><span class="o">();</span></div><div class='line' id='LC316'>&nbsp;&nbsp;&nbsp;&nbsp;	<span class="o">}</span></div><div class='line' id='LC317'>&nbsp;&nbsp;&nbsp;&nbsp;	<span class="n">mDrawerLayout</span><span class="o">.</span><span class="na">closeDrawer</span><span class="o">(</span><span class="n">mDrawerList</span><span class="o">);</span></div><div class='line' id='LC318'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span></div><div class='line' id='LC319'><br/></div><div class='line' id='LC320'><br/></div><div class='line' id='LC321'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="nd">@Override</span></div><div class='line' id='LC322'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">public</span> <span class="kt">void</span> <span class="nf">setTitle</span><span class="o">(</span><span class="n">CharSequence</span> <span class="n">title</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC323'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">mTitle</span> <span class="o">=</span> <span class="n">title</span><span class="o">;</span></div><div class='line' id='LC324'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">getActionBar</span><span class="o">().</span><span class="na">setTitle</span><span class="o">(</span><span class="n">mTitle</span><span class="o">);</span></div><div class='line' id='LC325'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span></div><div class='line' id='LC326'>&nbsp;&nbsp;&nbsp;&nbsp;</div><div class='line' id='LC327'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="nd">@Override</span></div><div class='line' id='LC328'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">protected</span> <span class="kt">void</span> <span class="nf">onPostCreate</span><span class="o">(</span><span class="n">Bundle</span> <span class="n">savedInstanceState</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC329'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">super</span><span class="o">.</span><span class="na">onPostCreate</span><span class="o">(</span><span class="n">savedInstanceState</span><span class="o">);</span></div><div class='line' id='LC330'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="c1">// Sync the toggle state after onRestoreInstanceState has occurred.</span></div><div class='line' id='LC331'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">mDrawerToggle</span><span class="o">.</span><span class="na">syncState</span><span class="o">();</span></div><div class='line' id='LC332'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span></div><div class='line' id='LC333'><br/></div><div class='line' id='LC334'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="nd">@Override</span></div><div class='line' id='LC335'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">public</span> <span class="kt">void</span> <span class="nf">onConfigurationChanged</span><span class="o">(</span><span class="n">Configuration</span> <span class="n">newConfig</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC336'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">super</span><span class="o">.</span><span class="na">onConfigurationChanged</span><span class="o">(</span><span class="n">newConfig</span><span class="o">);</span></div><div class='line' id='LC337'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">mDrawerToggle</span><span class="o">.</span><span class="na">onConfigurationChanged</span><span class="o">(</span><span class="n">newConfig</span><span class="o">);</span></div><div class='line' id='LC338'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span></div><div class='line' id='LC339'>&nbsp;&nbsp;&nbsp;&nbsp;</div><div class='line' id='LC340'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="nd">@Override</span></div><div class='line' id='LC341'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">public</span> <span class="kt">boolean</span> <span class="nf">onOptionsItemSelected</span><span class="o">(</span><span class="n">MenuItem</span> <span class="n">item</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC342'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="c1">// Pass the event to ActionBarDrawerToggle, if it returns</span></div><div class='line' id='LC343'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="c1">// true, then it has handled the app icon touch event</span></div><div class='line' id='LC344'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="o">(</span><span class="n">mDrawerToggle</span><span class="o">.</span><span class="na">onOptionsItemSelected</span><span class="o">(</span><span class="n">item</span><span class="o">))</span> <span class="o">{</span></div><div class='line' id='LC345'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="kc">true</span><span class="o">;</span></div><div class='line' id='LC346'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span></div><div class='line' id='LC347'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="c1">// Handle your other action bar items...</span></div><div class='line' id='LC348'><br/></div><div class='line' id='LC349'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="kd">super</span><span class="o">.</span><span class="na">onOptionsItemSelected</span><span class="o">(</span><span class="n">item</span><span class="o">);</span></div><div class='line' id='LC350'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span></div><div class='line' id='LC351'>&nbsp;&nbsp;&nbsp;&nbsp;</div><div class='line' id='LC352'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="nd">@Override</span></div><div class='line' id='LC353'>&nbsp;&nbsp;&nbsp;	<span class="kd">public</span> <span class="kt">void</span> <span class="nf">onCategorySelected</span><span class="o">(</span><span class="kt">int</span> <span class="n">itemId</span><span class="o">,</span> <span class="n">String</span> <span class="n">type</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC354'>&nbsp;&nbsp;&nbsp;&nbsp;	<span class="k">if</span><span class="o">(</span><span class="n">type</span><span class="o">.</span><span class="na">equals</span><span class="o">(</span><span class="s">&quot;category&quot;</span><span class="o">))</span> <span class="o">{</span></div><div class='line' id='LC355'>	    	<span class="n">CategoryFragment</span> <span class="n">categoryFragment</span> <span class="o">=</span> <span class="k">new</span> <span class="n">CategoryFragment</span><span class="o">();</span></div><div class='line' id='LC356'><br/></div><div class='line' id='LC357'>	    	<span class="n">Bundle</span> <span class="n">args</span> <span class="o">=</span> <span class="k">new</span> <span class="n">Bundle</span><span class="o">();</span></div><div class='line' id='LC358'>	        <span class="n">args</span><span class="o">.</span><span class="na">putInt</span><span class="o">(</span><span class="n">CategoryFragment</span><span class="o">.</span><span class="na">PARENT_ID</span><span class="o">,</span> <span class="n">itemId</span><span class="o">);</span></div><div class='line' id='LC359'>	        <span class="n">categoryFragment</span><span class="o">.</span><span class="na">setArguments</span><span class="o">(</span><span class="n">args</span><span class="o">);</span></div><div class='line' id='LC360'><br/></div><div class='line' id='LC361'>	        <span class="n">FragmentTransaction</span> <span class="n">transaction</span> <span class="o">=</span> <span class="n">getSupportFragmentManager</span><span class="o">().</span><span class="na">beginTransaction</span><span class="o">();</span></div><div class='line' id='LC362'>			<span class="n">transaction</span><span class="o">.</span><span class="na">replace</span><span class="o">(</span><span class="n">R</span><span class="o">.</span><span class="na">id</span><span class="o">.</span><span class="na">content_frame</span><span class="o">,</span> <span class="n">categoryFragment</span><span class="o">);</span></div><div class='line' id='LC363'>	        <span class="n">transaction</span><span class="o">.</span><span class="na">addToBackStack</span><span class="o">(</span><span class="kc">null</span><span class="o">);</span></div><div class='line' id='LC364'><br/></div><div class='line' id='LC365'>	        <span class="c1">// Commit the transaction</span></div><div class='line' id='LC366'>	        <span class="n">transaction</span><span class="o">.</span><span class="na">commit</span><span class="o">();</span></div><div class='line' id='LC367'>&nbsp;&nbsp;&nbsp;&nbsp;	<span class="o">}</span> <span class="k">else</span> <span class="k">if</span><span class="o">(</span><span class="n">type</span><span class="o">.</span><span class="na">equals</span><span class="o">(</span><span class="s">&quot;content&quot;</span><span class="o">))</span> <span class="o">{</span></div><div class='line' id='LC368'>&nbsp;&nbsp;&nbsp;&nbsp;		<span class="n">MessageFragment</span> <span class="n">messageFragment</span> <span class="o">=</span> <span class="k">new</span> <span class="n">MessageFragment</span><span class="o">();</span></div><div class='line' id='LC369'>&nbsp;&nbsp;&nbsp;&nbsp;		</div><div class='line' id='LC370'>&nbsp;&nbsp;&nbsp;&nbsp;		<span class="n">Bundle</span> <span class="n">args</span> <span class="o">=</span> <span class="k">new</span> <span class="n">Bundle</span><span class="o">();</span></div><div class='line' id='LC371'>	        <span class="n">args</span><span class="o">.</span><span class="na">putInt</span><span class="o">(</span><span class="n">MessageFragment</span><span class="o">.</span><span class="na">CONTENT_ID</span><span class="o">,</span> <span class="n">itemId</span><span class="o">);</span></div><div class='line' id='LC372'>	        <span class="n">messageFragment</span><span class="o">.</span><span class="na">setArguments</span><span class="o">(</span><span class="n">args</span><span class="o">);</span></div><div class='line' id='LC373'><br/></div><div class='line' id='LC374'>	        <span class="n">FragmentTransaction</span> <span class="n">transaction</span> <span class="o">=</span> <span class="n">getSupportFragmentManager</span><span class="o">().</span><span class="na">beginTransaction</span><span class="o">();</span></div><div class='line' id='LC375'>			<span class="n">transaction</span><span class="o">.</span><span class="na">replace</span><span class="o">(</span><span class="n">R</span><span class="o">.</span><span class="na">id</span><span class="o">.</span><span class="na">content_frame</span><span class="o">,</span> <span class="n">messageFragment</span><span class="o">);</span></div><div class='line' id='LC376'>	        <span class="n">transaction</span><span class="o">.</span><span class="na">addToBackStack</span><span class="o">(</span><span class="kc">null</span><span class="o">);</span></div><div class='line' id='LC377'><br/></div><div class='line' id='LC378'>	        <span class="c1">// Commit the transaction</span></div><div class='line' id='LC379'>	        <span class="n">transaction</span><span class="o">.</span><span class="na">commit</span><span class="o">();</span></div><div class='line' id='LC380'>&nbsp;&nbsp;&nbsp;&nbsp;	<span class="o">}</span></div><div class='line' id='LC381'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span></div><div class='line' id='LC382'>&nbsp;&nbsp;&nbsp;&nbsp;</div><div class='line' id='LC383'><span class="o">}</span></div></pre></div></td>
          </tr>
        </table>
  </div>

  </div>
</div>

<a href="#jump-to-line" rel="facebox[.linejump]" data-hotkey="l" class="js-jump-to-line" style="display:none">Jump to Line</a>
<div id="jump-to-line" style="display:none">
  <form accept-charset="UTF-8" class="js-jump-to-line-form">
    <input class="linejump-input js-jump-to-line-field" type="text" placeholder="Jump to line&hellip;" autofocus>
    <button type="submit" class="button">Go</button>
  </form>
</div>

        </div>

      </div><!-- /.repo-container -->
      <div class="modal-backdrop"></div>
    </div><!-- /.container -->
  </div><!-- /.site -->


    </div><!-- /.wrapper -->

      <div class="container">
  <div class="site-footer">
    <ul class="site-footer-links right">
      <li><a href="https://status.github.com/">Status</a></li>
      <li><a href="http://developer.github.com">API</a></li>
      <li><a href="http://training.github.com">Training</a></li>
      <li><a href="http://shop.github.com">Shop</a></li>
      <li><a href="/blog">Blog</a></li>
      <li><a href="/about">About</a></li>

    </ul>

    <a href="/">
      <span class="mega-octicon octicon-mark-github" title="GitHub"></span>
    </a>

    <ul class="site-footer-links">
      <li>&copy; 2014 <span title="0.06600s from github-fe132-cp1-prd.iad.github.net">GitHub</span>, Inc.</li>
        <li><a href="/site/terms">Terms</a></li>
        <li><a href="/site/privacy">Privacy</a></li>
        <li><a href="/security">Security</a></li>
        <li><a href="/contact">Contact</a></li>
    </ul>
  </div><!-- /.site-footer -->
</div><!-- /.container -->


    <div class="fullscreen-overlay js-fullscreen-overlay" id="fullscreen_overlay">
  <div class="fullscreen-container js-fullscreen-container">
    <div class="textarea-wrap">
      <textarea name="fullscreen-contents" id="fullscreen-contents" class="js-fullscreen-contents" placeholder="" data-suggester="fullscreen_suggester"></textarea>
    </div>
  </div>
  <div class="fullscreen-sidebar">
    <a href="#" class="exit-fullscreen js-exit-fullscreen tooltipped tooltipped-w" aria-label="Exit Zen Mode">
      <span class="mega-octicon octicon-screen-normal"></span>
    </a>
    <a href="#" class="theme-switcher js-theme-switcher tooltipped tooltipped-w"
      aria-label="Switch themes">
      <span class="octicon octicon-color-mode"></span>
    </a>
  </div>
</div>



    <div id="ajax-error-message" class="flash flash-error">
      <span class="octicon octicon-alert"></span>
      <a href="#" class="octicon octicon-remove-close close js-ajax-error-dismiss"></a>
      Something went wrong with that request. Please try again.
    </div>

  </body>
</html>

