/**
 * This file was converted to Java from the original LLVM source file. The original
 * source file follows the LLVM Release License, outlined below.
 * 
 * ==============================================================================
 * LLVM Release License
 * ==============================================================================
 * University of Illinois/NCSA
 * Open Source License
 * 
 * Copyright (c) 2003-2017 University of Illinois at Urbana-Champaign.
 * All rights reserved.
 * 
 * Developed by:
 * 
 *     LLVM Team
 * 
 *     University of Illinois at Urbana-Champaign
 * 
 *     http://llvm.org
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal with
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 * 
 *     * Redistributions of source code must retain the above copyright notice,
 *       this list of conditions and the following disclaimers.
 * 
 *     * Redistributions in binary form must reproduce the above copyright notice
 *       this list of conditions and the following disclaimers in the
 *       documentation and/or other materials provided with the distribution.
 * 
 *     * Neither the names of the LLVM Team, University of Illinois at
 *       Urbana-Champaign, nor the names of its contributors may be used to
 *       endorse or promote products derived from this Software without specific
 *       prior written permission.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.  IN NO EVENT SHALL THE
 * CONTRIBUTORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS WITH THE
 * SOFTWARE.
 * 
 * ==============================================================================
 * Copyrights and Licenses for Third Party Software Distributed with LLVM:
 * ==============================================================================
 * The LLVM software contains code written by third parties.  Such software will
 * have its own individual LICENSE.TXT file in the directory in which it appears.
 * This file will describe the copyrights, license, and restrictions which apply
 * to that code.
 * 
 * The disclaimer of warranty in the University of Illinois Open Source License
 * applies to all code in the LLVM Distribution, and nothing in any of the
 * other licenses gives permission to use the names of the LLVM Team or the
 * University of Illinois to endorse or promote products derived from this
 * Software.
 * 
 * The following pieces of software have additional or alternate copyrights,
 * licenses, and/or restrictions:
 * 
 * Program             Directory
 * -------             ---------
 * Autoconf            llvm/autoconf
 *                     llvm/projects/ModuleMaker/autoconf
 * Google Test         llvm/utils/unittest/googletest
 * OpenBSD regex       llvm/lib/Support/{reg*, COPYRIGHT.regex}
 * pyyaml tests        llvm/test/YAMLParser/{*.data, LICENSE.TXT}
 * ARM contributions   llvm/lib/Target/ARM/LICENSE.TXT
 * md5 contributions   llvm/lib/Support/MD5.cpp llvm/include/llvm/Support/MD5.h
 */

package org.clang.lex;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import org.llvm.adt.*;
import org.clang.lex.*;
import org.clang.lex.frontend.IncludeDirGroup;


/// HeaderSearchOptions - Helper class for storing options related to the
/// initialization of the HeaderSearch object.
//<editor-fold defaultstate="collapsed" desc="clang::HeaderSearchOptions">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearchOptions.h", line = 46,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearchOptions.h", old_line = 45,
 FQN="clang::HeaderSearchOptions", NM="_ZN5clang19HeaderSearchOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZN5clang19HeaderSearchOptionsE")
//</editor-fold>
public class HeaderSearchOptions extends /*public*/ RefCountedBase<HeaderSearchOptions> implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearchOptions::Entry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearchOptions.h", line = 48,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearchOptions.h", old_line = 47,
   FQN="clang::HeaderSearchOptions::Entry", NM="_ZN5clang19HeaderSearchOptions5EntryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZN5clang19HeaderSearchOptions5EntryE")
  //</editor-fold>
  public static class/*struct*/ Entry implements Destructors.ClassWithDestructor {
    public std.string Path;
    public IncludeDirGroup Group;
    public /*JBIT unsigned int*/ boolean IsFramework /*: 1*/;
    
    /// IgnoreSysRoot - This is false if an absolute path should be treated
    /// relative to the sysroot, or true if it should always be the absolute
    /// path.
    public /*JBIT unsigned int*/ boolean IgnoreSysRoot /*: 1*/;
    
    //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearchOptions::Entry::Entry">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearchOptions.h", line = 58,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearchOptions.h", old_line = 57,
     FQN="clang::HeaderSearchOptions::Entry::Entry", NM="_ZN5clang19HeaderSearchOptions5EntryC1EN4llvm9StringRefENS_8frontend15IncludeDirGroupEbb",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZN5clang19HeaderSearchOptions5EntryC1EN4llvm9StringRefENS_8frontend15IncludeDirGroupEbb")
    //</editor-fold>
    public Entry(StringRef path, IncludeDirGroup group, boolean isFramework, 
        boolean ignoreSysRoot) {
      /* : Path(path.operator basic_string()), Group(group), IsFramework(isFramework), IgnoreSysRoot(ignoreSysRoot)*/ 
      //START JInit
      this.Path = path.$string();
      this.Group = group;
      this.IsFramework = isFramework;
      this.IgnoreSysRoot = ignoreSysRoot;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearchOptions::Entry::Entry">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearchOptions.h", line = 48,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearchOptions.h", old_line = 47,
     FQN="clang::HeaderSearchOptions::Entry::Entry", NM="_ZN5clang19HeaderSearchOptions5EntryC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZN5clang19HeaderSearchOptions5EntryC1ERKS1_")
    //</editor-fold>
    public /*inline*/ Entry(/*const*/ Entry /*&*/ $Prm0) {
      /* : Path(.Path), Group(.Group), IsFramework(.IsFramework), IgnoreSysRoot(.IgnoreSysRoot)*/ 
      //START JInit
      this.Path = new std.string($Prm0.Path);
      this.Group = $Prm0.Group;
      this.IsFramework = $Prm0.IsFramework;
      this.IgnoreSysRoot = $Prm0.IgnoreSysRoot;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearchOptions::Entry::Entry">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearchOptions.h", line = 48,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearchOptions.h", old_line = 47,
     FQN="clang::HeaderSearchOptions::Entry::Entry", NM="_ZN5clang19HeaderSearchOptions5EntryC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZN5clang19HeaderSearchOptions5EntryC1EOS1_")
    //</editor-fold>
    public /*inline*/ Entry(JD$Move _dparam, Entry /*&&*/$Prm0) {
      /* : Path(static_cast<Entry &&>().Path), Group(static_cast<Entry &&>().Group), IsFramework(static_cast<Entry &&>().IsFramework), IgnoreSysRoot(static_cast<Entry &&>().IgnoreSysRoot)*/ 
      //START JInit
      this.Path = new std.string(JD$Move.INSTANCE, $Prm0.Path);
      this.Group = $Prm0.Group;
      this.IsFramework = $Prm0.IsFramework;
      this.IgnoreSysRoot = $Prm0.IgnoreSysRoot;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearchOptions::Entry::~Entry">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearchOptions.h", line = 48,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearchOptions.h", old_line = 47,
     FQN="clang::HeaderSearchOptions::Entry::~Entry", NM="_ZN5clang19HeaderSearchOptions5EntryD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZN5clang19HeaderSearchOptions5EntryD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      Path.$destroy();
      //END JDestroy
    }

    
    public String toString() {
      return "" + "Path=" + Path // NOI18N
                + ", Group=" + Group // NOI18N
                + ", IsFramework=" + IsFramework // NOI18N
                + ", IgnoreSysRoot=" + IgnoreSysRoot; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearchOptions::SystemHeaderPrefix">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearchOptions.h", line = 64,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearchOptions.h", old_line = 63,
   FQN="clang::HeaderSearchOptions::SystemHeaderPrefix", NM="_ZN5clang19HeaderSearchOptions18SystemHeaderPrefixE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZN5clang19HeaderSearchOptions18SystemHeaderPrefixE")
  //</editor-fold>
  public static class/*struct*/ SystemHeaderPrefix implements Destructors.ClassWithDestructor {
    /// A prefix to be matched against paths in \#include directives.
    public std.string Prefix;
    
    /// True if paths beginning with this prefix should be treated as system
    /// headers.
    public boolean IsSystemHeader;    
    
    //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearchOptions::SystemHeaderPrefix::SystemHeaderPrefix">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearchOptions.h", line = 72,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearchOptions.h", old_line = 71,
     FQN="clang::HeaderSearchOptions::SystemHeaderPrefix::SystemHeaderPrefix", NM="_ZN5clang19HeaderSearchOptions18SystemHeaderPrefixC1EN4llvm9StringRefEb",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZN5clang19HeaderSearchOptions18SystemHeaderPrefixC1EN4llvm9StringRefEb")
    //</editor-fold>
    public SystemHeaderPrefix(StringRef Prefix, boolean IsSystemHeader) {
      /* : Prefix(Prefix.operator basic_string()), IsSystemHeader(IsSystemHeader)*/ 
      //START JInit
      this.Prefix = Prefix.$string();
      this.IsSystemHeader = IsSystemHeader;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearchOptions::SystemHeaderPrefix::SystemHeaderPrefix">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearchOptions.h", line = 64,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearchOptions.h", old_line = 63,
     FQN="clang::HeaderSearchOptions::SystemHeaderPrefix::SystemHeaderPrefix", NM="_ZN5clang19HeaderSearchOptions18SystemHeaderPrefixC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZN5clang19HeaderSearchOptions18SystemHeaderPrefixC1ERKS1_")
    //</editor-fold>
    public /*inline*/ SystemHeaderPrefix(/*const*/ SystemHeaderPrefix /*&*/ $Prm0) {
      /* : Prefix(.Prefix), IsSystemHeader(.IsSystemHeader)*/ 
      //START JInit
      this.Prefix = new std.string($Prm0.Prefix);
      this.IsSystemHeader = $Prm0.IsSystemHeader;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearchOptions::SystemHeaderPrefix::SystemHeaderPrefix">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearchOptions.h", line = 64,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearchOptions.h", old_line = 63,
     FQN="clang::HeaderSearchOptions::SystemHeaderPrefix::SystemHeaderPrefix", NM="_ZN5clang19HeaderSearchOptions18SystemHeaderPrefixC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZN5clang19HeaderSearchOptions18SystemHeaderPrefixC1EOS1_")
    //</editor-fold>
    public /*inline*/ SystemHeaderPrefix(JD$Move _dparam, SystemHeaderPrefix /*&&*/$Prm0) {
      /* : Prefix(static_cast<SystemHeaderPrefix &&>().Prefix), IsSystemHeader(static_cast<SystemHeaderPrefix &&>().IsSystemHeader)*/ 
      //START JInit
      this.Prefix = new std.string(JD$Move.INSTANCE, $Prm0.Prefix);
      this.IsSystemHeader = $Prm0.IsSystemHeader;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearchOptions::SystemHeaderPrefix::~SystemHeaderPrefix">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearchOptions.h", line = 64,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearchOptions.h", old_line = 63,
     FQN="clang::HeaderSearchOptions::SystemHeaderPrefix::~SystemHeaderPrefix", NM="_ZN5clang19HeaderSearchOptions18SystemHeaderPrefixD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZN5clang19HeaderSearchOptions18SystemHeaderPrefixD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      Prefix.$destroy();
      //END JDestroy
    }

    
    public String toString() {
      return "" + "Prefix=" + Prefix // NOI18N
                + ", IsSystemHeader=" + IsSystemHeader; // NOI18N
    }
  };
  
  /// If non-empty, the directory to use as a "virtual system root" for include
  /// paths.
  public std.string Sysroot;
  
  /// JAVA:
  /// If non-empty, the directory to use as a prefix
  /// for absolute paths in #include directives
  public std.string AbsPathLookupPrefix = std.string.EMPTY;

  /// User specified include entries.
  public std.vector<Entry> UserEntries;
  
  /// User-specified system header prefixes.
  public std.vector<SystemHeaderPrefix> SystemHeaderPrefixes;
  
  /// The directory which holds the compiler resource files (builtin includes,
  /// etc.).
  public std.string ResourceDir;
  
  /// \brief The directory used for the module cache.
  public std.string ModuleCachePath;
  
  /// \brief The directory used for a user build.
  public std.string ModuleUserBuildPath;
  
  /// The module/pch container format.
  public std.string ModuleFormat;
  
  /// \brief Whether we should disable the use of the hash string within the
  /// module cache.
  ///
  /// Note: Only used for testing!
  public /*JBIT unsigned int*/ boolean DisableModuleHash /*: 1*/;
  
  /// \brief Implicit module maps.  This option is enabld by default when
  /// modules is enabled.
  public /*JBIT unsigned int*/ boolean ImplicitModuleMaps /*: 1*/;
  
  /// \brief Set the 'home directory' of a module map file to the current
  /// working directory (or the home directory of the module map file that
  /// contained the 'extern module' directive importing this module map file
  /// if any) rather than the directory containing the module map file.
  //
  /// The home directory is where we look for files named in the module map
  /// file.
  public /*JBIT unsigned int*/ boolean ModuleMapFileHomeIsCwd /*: 1*/;
  
  /// \brief The interval (in seconds) between pruning operations.
  ///
  /// This operation is expensive, because it requires Clang to walk through
  /// the directory structure of the module cache, stat()'ing and removing
  /// files.
  ///
  /// The default value is large, e.g., the operation runs once a week.
  public /*uint*/int ModuleCachePruneInterval;
  
  /// \brief The time (in seconds) after which an unused module file will be
  /// considered unused and will, therefore, be pruned.
  ///
  /// When the module cache is pruned, any module file that has not been
  /// accessed in this many seconds will be removed. The default value is
  /// large, e.g., a month, to avoid forcing infrequently-used modules to be
  /// regenerated often.
  public /*uint*/int ModuleCachePruneAfter;
  
  /// \brief The time in seconds when the build session started.
  ///
  /// This time is used by other optimizations in header search and module
  /// loading.
  public long/*uint64_t*/ BuildSessionTimestamp;
  
  /// \brief The set of macro names that should be ignored for the purposes
  /// of computing the module hash.
  public SmallSetVector<std.string> ModulesIgnoreMacros;
  
  /// \brief The set of user-provided virtual filesystem overlay files.
  public std.vectorString VFSOverlayFiles;
  
  /// Include the compiler builtin includes.
  public /*JBIT unsigned int*/ boolean UseBuiltinIncludes /*: 1*/;
  
  /// Include the system standard include search directories.
  public /*JBIT unsigned int*/ boolean UseStandardSystemIncludes /*: 1*/;
  
  /// Include the system standard C++ library include search directories.
  public /*JBIT unsigned int*/ boolean UseStandardCXXIncludes /*: 1*/;
  
  /// Use libc++ instead of the default libstdc++.
  public /*JBIT unsigned int*/ boolean UseLibcxx /*: 1*/;
  
  /// Whether header search information should be output as for -v.
  public /*JBIT unsigned int*/ boolean Verbose /*: 1*/;
  
  /// \brief If true, skip verifying input files used by modules if the
  /// module was already verified during this build session (see
  /// \c BuildSessionTimestamp).
  public /*JBIT unsigned int*/ boolean ModulesValidateOncePerBuildSession /*: 1*/;
  
  /// \brief Whether to validate system input files when a module is loaded.
  public /*JBIT unsigned int*/ boolean ModulesValidateSystemHeaders /*: 1*/;
  
  /// Whether the module includes debug information (-gmodules).
  public /*JBIT unsigned int*/ boolean UseDebugInfo /*: 1*/;
  
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearchOptions::HeaderSearchOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearchOptions.h", line = 175,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearchOptions.h", old_line = 168,
   FQN="clang::HeaderSearchOptions::HeaderSearchOptions", NM="_ZN5clang19HeaderSearchOptionsC1EN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZN5clang19HeaderSearchOptionsC1EN4llvm9StringRefE")
  //</editor-fold>
  public HeaderSearchOptions() {
    this(new StringRef(/*KEEP_STR*/$SLASH));
  }
  public HeaderSearchOptions(StringRef _Sysroot/*= "/"*/) {
    /* : RefCountedBase<HeaderSearchOptions>(), Sysroot(_Sysroot.operator basic_string()), UserEntries(), SystemHeaderPrefixes(), ResourceDir(), ModuleCachePath(), ModuleUserBuildPath(), ModuleFormat("raw"), DisableModuleHash(0), ImplicitModuleMaps(0), ModuleMapFileHomeIsCwd(0), ModuleCachePruneInterval(7 * 24 * 60 * 60), ModuleCachePruneAfter(31 * 24 * 60 * 60), BuildSessionTimestamp(0), ModulesIgnoreMacros(), VFSOverlayFiles(), UseBuiltinIncludes(true), UseStandardSystemIncludes(true), UseStandardCXXIncludes(true), UseLibcxx(false), Verbose(false), ModulesValidateOncePerBuildSession(false), ModulesValidateSystemHeaders(false), UseDebugInfo(false)*/ 
    //START JInit
    super();
    this.Sysroot = _Sysroot.$string();
    this.UserEntries = new std.vector<Entry>((Entry)null/*PERF:new Entry()*/);
    this.SystemHeaderPrefixes = new std.vector<SystemHeaderPrefix>((SystemHeaderPrefix)null/*PERF: new SystemHeaderPrefix()*/);
    this.ResourceDir = new std.string();
    this.ModuleCachePath = new std.string();
    this.ModuleUserBuildPath = new std.string();
    this.ModuleFormat = new std.string(/*KEEP_STR*/"raw");
    this.DisableModuleHash = false;
    this.ImplicitModuleMaps = false;
    this.ModuleMapFileHomeIsCwd = false;
    this.ModuleCachePruneInterval = 7 * 24 * 60 * 60;
    this.ModuleCachePruneAfter = 31 * 24 * 60 * 60;
    this.BuildSessionTimestamp = 0;
    this.ModulesIgnoreMacros = new SmallSetVector<std.string>(16, std.string.EMPTY);
    this.VFSOverlayFiles = new std.vectorString(std.string.EMPTY);
    this.UseBuiltinIncludes = true;
    this.UseStandardSystemIncludes = true;
    this.UseStandardCXXIncludes = true;
    this.UseLibcxx = false;
    this.Verbose = false;
    this.ModulesValidateOncePerBuildSession = false;
    this.ModulesValidateSystemHeaders = false;
    this.UseDebugInfo = false;
    //END JInit
  }

  
  /// AddPath - Add the \p Path path to the specified \p Group list.
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearchOptions::AddPath">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearchOptions.h", line = 187,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearchOptions.h", old_line = 181,
   FQN="clang::HeaderSearchOptions::AddPath", NM="_ZN5clang19HeaderSearchOptions7AddPathEN4llvm9StringRefENS_8frontend15IncludeDirGroupEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZN5clang19HeaderSearchOptions7AddPathEN4llvm9StringRefENS_8frontend15IncludeDirGroupEbb")
  //</editor-fold>
  public void AddPath(StringRef Path, IncludeDirGroup Group, 
         boolean IsFramework, boolean IgnoreSysRoot) {
    UserEntries.push_back(new Entry(Path, Group, IsFramework, IgnoreSysRoot));
  }

  
  /// AddSystemHeaderPrefix - Override whether \#include directives naming a
  /// path starting with \p Prefix should be considered as naming a system
  /// header.
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearchOptions::AddSystemHeaderPrefix">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearchOptions.h", line = 195,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearchOptions.h", old_line = 189,
   FQN="clang::HeaderSearchOptions::AddSystemHeaderPrefix", NM="_ZN5clang19HeaderSearchOptions21AddSystemHeaderPrefixEN4llvm9StringRefEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZN5clang19HeaderSearchOptions21AddSystemHeaderPrefixEN4llvm9StringRefEb")
  //</editor-fold>
  public void AddSystemHeaderPrefix(StringRef Prefix, boolean IsSystemHeader) {
    SystemHeaderPrefixes.push_back(new SystemHeaderPrefix(Prefix, IsSystemHeader));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearchOptions::AddVFSOverlayFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearchOptions.h", line = 199,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearchOptions.h", old_line = 193,
   FQN="clang::HeaderSearchOptions::AddVFSOverlayFile", NM="_ZN5clang19HeaderSearchOptions17AddVFSOverlayFileEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZN5clang19HeaderSearchOptions17AddVFSOverlayFileEN4llvm9StringRefE")
  //</editor-fold>
  public void AddVFSOverlayFile(StringRef Name) {
    VFSOverlayFiles.push_back(Name.$string());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearchOptions::HeaderSearchOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearchOptions.h", line = 46,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearchOptions.h", old_line = 45,
   FQN="clang::HeaderSearchOptions::HeaderSearchOptions", NM="_ZN5clang19HeaderSearchOptionsC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZN5clang19HeaderSearchOptionsC1ERKS0_")
  //</editor-fold>
  public /*inline*/ HeaderSearchOptions(/*const*/ HeaderSearchOptions /*&*/ $Prm0) {
    /* : RefCountedBase<HeaderSearchOptions>(), Sysroot(.Sysroot), UserEntries(.UserEntries), SystemHeaderPrefixes(.SystemHeaderPrefixes), ResourceDir(.ResourceDir), ModuleCachePath(.ModuleCachePath), ModuleUserBuildPath(.ModuleUserBuildPath), ModuleFormat(.ModuleFormat), DisableModuleHash(.DisableModuleHash), ImplicitModuleMaps(.ImplicitModuleMaps), ModuleMapFileHomeIsCwd(.ModuleMapFileHomeIsCwd), ModuleCachePruneInterval(.ModuleCachePruneInterval), ModuleCachePruneAfter(.ModuleCachePruneAfter), BuildSessionTimestamp(.BuildSessionTimestamp), ModulesIgnoreMacros(.ModulesIgnoreMacros), VFSOverlayFiles(.VFSOverlayFiles), UseBuiltinIncludes(.UseBuiltinIncludes), UseStandardSystemIncludes(.UseStandardSystemIncludes), UseStandardCXXIncludes(.UseStandardCXXIncludes), UseLibcxx(.UseLibcxx), Verbose(.Verbose), ModulesValidateOncePerBuildSession(.ModulesValidateOncePerBuildSession), ModulesValidateSystemHeaders(.ModulesValidateSystemHeaders), UseDebugInfo(.UseDebugInfo)*/ 
    //START JInit
    super($Prm0);
    this.Sysroot = new std.string($Prm0.Sysroot);
    this.UserEntries = new std.vector<Entry>($Prm0.UserEntries);
    this.SystemHeaderPrefixes = new std.vector<SystemHeaderPrefix>($Prm0.SystemHeaderPrefixes);
    this.ResourceDir = new std.string($Prm0.ResourceDir);
    this.ModuleCachePath = new std.string($Prm0.ModuleCachePath);
    this.ModuleUserBuildPath = new std.string($Prm0.ModuleUserBuildPath);
    this.ModuleFormat = new std.string($Prm0.ModuleFormat);
    this.DisableModuleHash = $Prm0.DisableModuleHash;
    this.ImplicitModuleMaps = $Prm0.ImplicitModuleMaps;
    this.ModuleMapFileHomeIsCwd = $Prm0.ModuleMapFileHomeIsCwd;
    this.ModuleCachePruneInterval = $Prm0.ModuleCachePruneInterval;
    this.ModuleCachePruneAfter = $Prm0.ModuleCachePruneAfter;
    this.BuildSessionTimestamp = $Prm0.BuildSessionTimestamp;
    this.ModulesIgnoreMacros = new SmallSetVector<std.string>($Prm0.ModulesIgnoreMacros);
    this.VFSOverlayFiles = new std.vectorString($Prm0.VFSOverlayFiles);
    this.UseBuiltinIncludes = $Prm0.UseBuiltinIncludes;
    this.UseStandardSystemIncludes = $Prm0.UseStandardSystemIncludes;
    this.UseStandardCXXIncludes = $Prm0.UseStandardCXXIncludes;
    this.UseLibcxx = $Prm0.UseLibcxx;
    this.Verbose = $Prm0.Verbose;
    this.ModulesValidateOncePerBuildSession = $Prm0.ModulesValidateOncePerBuildSession;
    this.ModulesValidateSystemHeaders = $Prm0.ModulesValidateSystemHeaders;
    this.UseDebugInfo = $Prm0.UseDebugInfo;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::HeaderSearchOptions::~HeaderSearchOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearchOptions.h", line = 46,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearchOptions.h", old_line = 45,
   FQN="clang::HeaderSearchOptions::~HeaderSearchOptions", NM="_ZN5clang19HeaderSearchOptionsD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZN5clang19HeaderSearchOptionsD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    VFSOverlayFiles.$destroy();
    ModulesIgnoreMacros.$destroy();
    ModuleFormat.$destroy();
    ModuleUserBuildPath.$destroy();
    ModuleCachePath.$destroy();
    ResourceDir.$destroy();
    SystemHeaderPrefixes.$destroy();
    UserEntries.$destroy();
    Sysroot.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  public String toString() {
    return "" + "Sysroot=" + Sysroot // NOI18N
              + ", UserEntries=" + UserEntries // NOI18N
              + ", SystemHeaderPrefixes=" + SystemHeaderPrefixes // NOI18N
              + ", ResourceDir=" + ResourceDir // NOI18N
              + ", ModuleCachePath=" + ModuleCachePath // NOI18N
              + ", ModuleUserBuildPath=" + ModuleUserBuildPath // NOI18N
              + ", ModuleFormat=" + ModuleFormat // NOI18N
              + ", DisableModuleHash=" + DisableModuleHash // NOI18N
              + ", ImplicitModuleMaps=" + ImplicitModuleMaps // NOI18N
              + ", ModuleMapFileHomeIsCwd=" + ModuleMapFileHomeIsCwd // NOI18N
              + ", ModuleCachePruneInterval=" + ModuleCachePruneInterval // NOI18N
              + ", ModuleCachePruneAfter=" + ModuleCachePruneAfter // NOI18N
              + ", BuildSessionTimestamp=" + BuildSessionTimestamp // NOI18N
              + ", ModulesIgnoreMacros=" + ModulesIgnoreMacros // NOI18N
              + ", VFSOverlayFiles=" + VFSOverlayFiles // NOI18N
              + ", UseBuiltinIncludes=" + UseBuiltinIncludes // NOI18N
              + ", UseStandardSystemIncludes=" + UseStandardSystemIncludes // NOI18N
              + ", UseStandardCXXIncludes=" + UseStandardCXXIncludes // NOI18N
              + ", UseLibcxx=" + UseLibcxx // NOI18N
              + ", Verbose=" + Verbose // NOI18N
              + ", ModulesValidateOncePerBuildSession=" + ModulesValidateOncePerBuildSession // NOI18N
              + ", ModulesValidateSystemHeaders=" + ModulesValidateSystemHeaders // NOI18N
              + ", UseDebugInfo=" + UseDebugInfo // NOI18N
              + super.toString(); // NOI18N
  }
}
