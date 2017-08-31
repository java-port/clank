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

package org.clang.basic.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.vfs.*;
import static org.clang.basic.impl.VirtualFileSystemStatics.*;
import org.clang.basic.vfs.detail.DirIterImpl;
import org.llvm.adt.ADTFunctionPointers.DiagHandlerTy;
import org.llvm.support.sys.path;
import org.llvm.support.sys.fs;
import org.llvm.support.yaml.*;


/// \brief A virtual file system parsed from a YAML file.
///
/// Currently, this class allows creating virtual directories and mapping
/// virtual file paths to existing external files, available in \c ExternalFS.
///
/// The basic structure of the parsed file is:
/// \verbatim
/// {
///   'version': <version number>,
///   <optional configuration>
///   'roots': [
///              <directory entries>
///            ]
/// }
/// \endverbatim
///
/// All configuration options are optional.
///   'case-sensitive': <boolean, default=true>
///   'use-external-names': <boolean, default=true>
///   'overlay-relative': <boolean, default=false>
///
/// Virtual directories are represented as
/// \verbatim
/// {
///   'type': 'directory',
///   'name': <string>,
///   'contents': [ <file or directory entries> ]
/// }
/// \endverbatim
///
/// The default attributes for virtual directories are:
/// \verbatim
/// MTime = now() when created
/// Perms = 0777
/// User = Group = 0
/// Size = 0
/// UniqueID = unspecified unique value
/// \endverbatim
///
/// Re-mapped files are represented as
/// \verbatim
/// {
///   'type': 'file',
///   'name': <string>,
///   'use-external-name': <boolean> # Optional
///   'external-contents': <path to external file>)
/// }
/// \endverbatim
///
/// and inherit their attributes from the external contents.
///
/// In both cases, the 'name' field may contain multiple path components (e.g.
/// /path/to/file). However, any directory that contains more than one child
/// must be uniquely represented by a directory entry.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RedirectingFileSystem">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*added $Ref fields for parser*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 838,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 813,
 FQN="(anonymous namespace)::RedirectingFileSystem", NM="_ZN12_GLOBAL__N_121RedirectingFileSystemE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_121RedirectingFileSystemE")
//</editor-fold>
public class RedirectingFileSystem extends /*public*/ FileSystem implements Destructors.ClassWithDestructor {
  /// The root(s) of the virtual file system.
  /*friend*//*private*/final std.vector<std.unique_ptr<Entry> > Roots;
  /// \brief The file system to use for external references.
  private IntrusiveRefCntPtr<FileSystem> ExternalFS;
  /// If IsRelativeOverlay is set, this represents the directory
  /// path that should be prefixed to each 'external-contents' entry
  /// when reading from YAML files.
  private std.string ExternalContentsPrefixDir;
  
  /// @name Configuration
  /// @{
  
  /// \brief Whether to perform case-sensitive comparisons.
  ///
  /// Currently, case-insensitive matching only works correctly with ASCII.
  private boolean CaseSensitive/* = true*/;
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  /*friend*//*private*/final bool$ref CaseSensitive$Ref = new bool$ref() {
    @Override public boolean $deref() { return RedirectingFileSystem.this.CaseSensitive; }
    @Override public boolean $set(boolean value) { return RedirectingFileSystem.this.CaseSensitive = value; }
  };
  
  /// IsRelativeOverlay marks whether a IsExternalContentsPrefixDir path must
  /// be prefixed in every 'external-contents' when reading from YAML files.
  private boolean IsRelativeOverlay/* = false*/;
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  /*friend*//*private*/final bool$ref IsRelativeOverlay$Ref = new bool$ref() {
    @Override public boolean $deref() { return RedirectingFileSystem.this.IsRelativeOverlay; }
    @Override public boolean $set(boolean value) { return RedirectingFileSystem.this.IsRelativeOverlay = value; }
  };
  
  /// \brief Whether to use to use the value of 'external-contents' for the
  /// names of files.  This global value is overridable on a per-file basis.
  private boolean UseExternalNames/* = true*/;
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  /*friend*//*private*/final bool$ref UseExternalNames$Ref = new bool$ref() {
    @Override public boolean $deref() { return RedirectingFileSystem.this.UseExternalNames; }
    @Override public boolean $set(boolean value) { return RedirectingFileSystem.this.UseExternalNames = value; }
  };
  /// @}
  
  /// Virtual file paths and external files could be canonicalized without "..",
  /// "." and "./" in their paths. FIXME: some unittests currently fail on
  /// win32 when using remove_dots and remove_leading_dotslash on paths.
  /*friend*//*private*/final boolean UseCanonicalizedPaths/* = true*/;
  
  /*friend  class RedirectingFileSystemParser*/
/*private:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RedirectingFileSystem::RedirectingFileSystem">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 878,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 835,
   FQN="(anonymous namespace)::RedirectingFileSystem::RedirectingFileSystem", NM="_ZN12_GLOBAL__N_121RedirectingFileSystemC1EN4llvm18IntrusiveRefCntPtrIN5clang3vfs10FileSystemEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_121RedirectingFileSystemC1EN4llvm18IntrusiveRefCntPtrIN5clang3vfs10FileSystemEEE")
  //</editor-fold>
  private RedirectingFileSystem(IntrusiveRefCntPtr<FileSystem> ExternalFS) {
    /* : FileSystem(), Roots(), ExternalFS(std::move(ExternalFS)), ExternalContentsPrefixDir(), CaseSensitive(true), IsRelativeOverlay(false), UseExternalNames(true), UseCanonicalizedPaths(true)*/ 
    //START JInit
    super();
    this.Roots = new std.vector<std.unique_ptr<Entry> >(new std.unique_ptr<Entry>());
    this.ExternalFS = new IntrusiveRefCntPtr<FileSystem>(JD$Move.INSTANCE, std.move(ExternalFS));
    this.ExternalContentsPrefixDir = new std.string();
    /*InClass*/this.CaseSensitive = true;
    /*InClass*/this.IsRelativeOverlay = false;
    /*InClass*/this.UseExternalNames = true;
    /*InClass*/this.UseCanonicalizedPaths = true;
    //END JInit
  }

  
  /// \brief Looks up \p Path in \c Roots.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RedirectingFileSystem::lookupPath">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 1430,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 1233,
   FQN="(anonymous namespace)::RedirectingFileSystem::lookupPath", NM="_ZN12_GLOBAL__N_121RedirectingFileSystem10lookupPathERKN4llvm5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_121RedirectingFileSystem10lookupPathERKN4llvm5TwineE")
  //</editor-fold>
  private ErrorOr<Entry /*P*/ > lookupPath(/*const*/ Twine /*&*/ Path_) {
    SmallString/*256*/ Path/*J*/= new SmallString/*256*/(256);
    Path_.toVector(Path);
    {
      
      // Handle relative paths
      std.error_code EC = makeAbsolute(Path);
      if (EC.$bool()) {
        return new ErrorOr<Entry /*P*/ >(new std.error_code(EC));
      }
    }
    
    // Canonicalize path by removing ".", "..", "./", etc components. This is
    // a VFS request, do bot bother about symlinks in the path components
    // but canonicalize in order to perform the correct entry search.
    if (UseCanonicalizedPaths) {
      Path.$assign(path.remove_leading_dotslash(Path.$StringRef()));
      path.remove_dots(Path, /*remove_dot_dot=*/ true);
    }
    if (Path.empty()) {
      return new ErrorOr<Entry /*P*/ >(make_error_code(errc.invalid_argument));
    }
    
    path.const_iterator Start = path.begin(Path.$StringRef());
    path.const_iterator End = path.end(Path.$StringRef());
    for (/*const*/ std.unique_ptr<Entry> /*&*/ Root : Roots) {
      ErrorOr<Entry /*P*/ > Result = lookupPath(new path.const_iterator(Start), new path.const_iterator(End), Root.get());
      if (Result.$bool() || $noteq_error_code(Result.getError(), new error_code(errc.no_such_file_or_directory))) {
        return Result;
      }
    }
    return new ErrorOr<Entry /*P*/ >(make_error_code(errc.no_such_file_or_directory));
  }

  
  /// \brief Looks up the path <tt>[Start, End)</tt> in \p From, possibly
  /// recursing into the contents of \p From if it is a directory.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RedirectingFileSystem::lookupPath">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 1459,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 1254,
   FQN="(anonymous namespace)::RedirectingFileSystem::lookupPath", NM="_ZN12_GLOBAL__N_121RedirectingFileSystem10lookupPathEN4llvm3sys4path14const_iteratorES4_PNS_5EntryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_121RedirectingFileSystem10lookupPathEN4llvm3sys4path14const_iteratorES4_PNS_5EntryE")
  //</editor-fold>
  private ErrorOr<Entry /*P*/ > lookupPath(path.const_iterator Start, 
            path.const_iterator End, Entry /*P*/ From) {
    assert (!isTraversalComponent(/*NO_COPY*/Start.$star()) && !isTraversalComponent(From.getName())) : "Paths should not contain traversal components";
    
    StringRef FromName = From.getName();
    
    // Forward the search to the next component in case this is an empty one.
    if (!FromName.empty()) {
      if (CaseSensitive ? !Start.$arrow().equals(/*NO_COPY*/FromName) : !Start.$arrow().equals_lower(/*NO_COPY*/FromName)) {
        // failure to match
        return new ErrorOr<Entry /*P*/ >(make_error_code(errc.no_such_file_or_directory));
      }
      
      Start.$preInc();
      if (Start.$eq(End)) {
        // Match!
        return new ErrorOr<Entry /*P*/ >(JD$Convertible.INSTANCE, From);
      }
    }
    
    RedirectingDirectoryEntry /*P*/ DE = dyn_cast(RedirectingDirectoryEntry.class, From);
    if (!(DE != null)) {
      return new ErrorOr<Entry /*P*/ >(make_error_code(errc.not_a_directory));
    }
    
    for (/*const*/ std.unique_ptr<Entry> /*&*/ DirEntry : llvm.make_range(DE.contents_begin(), DE.contents_end())) {
      ErrorOr<Entry /*P*/ > Result = lookupPath(new path.const_iterator(Start), new path.const_iterator(End), DirEntry.get());
      if (Result.$bool() || $noteq_error_code(Result.getError(), new error_code(errc.no_such_file_or_directory))) {
        return Result;
      }
    }
    return new ErrorOr<Entry /*P*/ >(make_error_code(errc.no_such_file_or_directory));
  }

  
  /// \brief Get the status of a given an \c Entry.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RedirectingFileSystem::status">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 1512,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 1295,
   FQN="(anonymous namespace)::RedirectingFileSystem::status", NM="_ZN12_GLOBAL__N_121RedirectingFileSystem6statusERKN4llvm5TwineEPNS_5EntryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_121RedirectingFileSystem6statusERKN4llvm5TwineEPNS_5EntryE")
  //</editor-fold>
  private ErrorOr<Status> status(/*const*/ Twine /*&*/ Path, Entry /*P*/ E) {
    assert (E != null);
    {
      RedirectingFileEntry /*P*/ F = dyn_cast(RedirectingFileEntry.class, E);
      if ((F != null)) {
        ErrorOr<Status> S = ExternalFS.$arrow().status(new Twine(F.getExternalContentsPath()));
        assert (!S.$bool() || $eq_StringRef(S.$arrow().getName(), F.getExternalContentsPath()));
        if (S.$bool()) {
          return new ErrorOr<Status>(JD$Convertible.INSTANCE, getRedirectedFileStatus(Path, F.useExternalName(UseExternalNames), 
                  new Status(S.$star())));
        }
        return S;
      } else { // directory
        RedirectingDirectoryEntry /*P*/ DE = cast(RedirectingDirectoryEntry.class, E);
        return new ErrorOr<Status>(JD$Convertible.INSTANCE, Status.copyWithNewName(DE.getStatus(), new StringRef(Path.str())));
      }
    }
  }

/*public:*/
  /// \brief Parses \p Buffer, which is expected to be in YAML format and
  /// returns a virtual file system representing its contents.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RedirectingFileSystem::create">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 1386,
   FQN="(anonymous namespace)::RedirectingFileSystem::create", NM="_ZN12_GLOBAL__N_121RedirectingFileSystem6createESt10unique_ptrIN4llvm12MemoryBufferESt14default_deleteIS3_EEPFvRKNS2_12SMDiagnosticEPvENS2_9StringRefESA_NS2_18IntrusiveRefCntPtrIN5clang3vfs10FileSystemEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_121RedirectingFileSystem6createESt10unique_ptrIN4llvm12MemoryBufferESt14default_deleteIS3_EEPFvRKNS2_12SMDiagnosticEPvENS2_9StringRefESA_NS2_18IntrusiveRefCntPtrIN5clang3vfs10FileSystemEEE")
  //</editor-fold>
  public static RedirectingFileSystem /*P*/ create(std.unique_ptr<MemoryBuffer> Buffer, 
        DiagHandlerTy DiagHandler, 
        StringRef YAMLFilePath, Object/*void P*/ DiagContext, 
        IntrusiveRefCntPtr<FileSystem> ExternalFS) {
    SourceMgr SM = null;
    Stream Stream = null;
    std.unique_ptr<RedirectingFileSystem> FS = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      
      SM/*J*/= new SourceMgr();
      Stream/*J*/= new Stream(Buffer.$arrow().getMemBufferRef(), SM);
      
      SM.setDiagHandler(DiagHandler, DiagContext);
      document_iterator DI = Stream.begin();
      Node /*P*/ Root = DI.$arrow().$arrow().getRoot();
      if (DI.$eq(Stream.end()) || !(Root != null)) {
        SM.PrintMessage(new SMLoc(), SourceMgr.DiagKind.DK_Error, new Twine(/*KEEP_STR*/"expected root node"));
        return null;
      }
      
      RedirectingFileSystemParser P/*J*/= new RedirectingFileSystemParser(Stream);
      
      FS/*J*/= $c$.clean(new std.unique_ptr<RedirectingFileSystem>(new RedirectingFileSystem($c$.track(new IntrusiveRefCntPtr<FileSystem>(JD$Move.INSTANCE, std.move(ExternalFS))))));
      if (!YAMLFilePath.empty()) {
        // Use the YAML path from -ivfsoverlay to compute the dir to be prefixed
        // to each 'external-contents' path.
        //
        // Example:
        //    -ivfsoverlay dummy.cache/vfs/vfs.yaml
        // yields:
        //  FS->ExternalContentsPrefixDir => /<absolute_path_to>/dummy.cache/vfs
        //
        SmallString/*256*/ OverlayAbsDir = new SmallString/*256*/(256, path.parent_path(/*NO_COPY*/YAMLFilePath));
        std.error_code EC = fs.make_absolute(OverlayAbsDir);
        assert (!EC.$bool()) : "Overlay dir final path must be absolute";
        /*(void)EC;*/
        FS.$arrow().setExternalContentsPrefixDir(OverlayAbsDir.$StringRef());
      }
      if (!P.parse(Root, FS.get())) {
        return null;
      }
      
      return FS.release();
    } finally {
      if (FS != null) { FS.$destroy(); }
      if (Stream != null) { Stream.$destroy(); }
      if (SM != null) { SM.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RedirectingFileSystem::status">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 1527,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 1310,
   FQN="(anonymous namespace)::RedirectingFileSystem::status", NM="_ZN12_GLOBAL__N_121RedirectingFileSystem6statusERKN4llvm5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_121RedirectingFileSystem6statusERKN4llvm5TwineE")
  //</editor-fold>
  @Override public ErrorOr<Status> status(/*const*/ Twine /*&*/ Path)/* override*/ {
    ErrorOr<Entry /*P*/ > Result = lookupPath(Path);
    if (!Result.$bool()) {
      return new ErrorOr<Status>(Result.getError());
    }
    return status(Path, Result.$star());
  }

  // end anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RedirectingFileSystem::openFileForRead">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 1555,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 1338,
   FQN="(anonymous namespace)::RedirectingFileSystem::openFileForRead", NM="_ZN12_GLOBAL__N_121RedirectingFileSystem15openFileForReadERKN4llvm5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_121RedirectingFileSystem15openFileForReadERKN4llvm5TwineE")
  //</editor-fold>
  @Override public ErrorOr<std.unique_ptr<File> > openFileForRead(/*const*/ Twine /*&*/ Path)/* override*/ {
    ErrorOr<unique_ptr<File> > Result = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      ErrorOr<Entry /*P*/ > E = lookupPath(Path);
      if (!E.$bool()) {
        return new ErrorOr<std.unique_ptr<File> >(E.getError());
      }
      
      RedirectingFileEntry /*P*/ F = dyn_cast(RedirectingFileEntry.class, E.$star());
      if (!(F != null)) { // FIXME: errc::not_a_file?
        return new ErrorOr<std.unique_ptr<File> >(make_error_code(errc.invalid_argument));
      }
      
      Result = ExternalFS.$arrow().openFileForRead(new Twine(F.getExternalContentsPath()));
      if (!Result.$bool()) {
        return new ErrorOr<std.unique_ptr<File> >(JD$Move.INSTANCE, Result);
      }
      
      ErrorOr<Status> ExternalStatus = (Result.$star()).$arrow().status();
      if (!ExternalStatus.$bool()) {
        return new ErrorOr<std.unique_ptr<File> >(ExternalStatus.getError());
      }
      
      // FIXME: Update the status with the name and VFSMapped.
      Status S = getRedirectedFileStatus(Path, F.useExternalName(UseExternalNames), 
          new Status(ExternalStatus.$star()));
      return $c$.clean(new ErrorOr<std.unique_ptr<File> >(JD$Convertible.INSTANCE, $c$.track(new std.unique_ptr<File>($c$.track(llvm.make_unique(new FileWithFixedStatus(std.move(Result.$star()), S)))))));
    } finally {
      if (Result != null) { Result.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RedirectingFileSystem::getCurrentWorkingDirectory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 903,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 860,
   FQN="(anonymous namespace)::RedirectingFileSystem::getCurrentWorkingDirectory", NM="_ZNK12_GLOBAL__N_121RedirectingFileSystem26getCurrentWorkingDirectoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZNK12_GLOBAL__N_121RedirectingFileSystem26getCurrentWorkingDirectoryEv")
  //</editor-fold>
  @Override public ErrorOr<std.string> getCurrentWorkingDirectory() /*const*//* override*/ {
    return ExternalFS.$arrow().getCurrentWorkingDirectory();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RedirectingFileSystem::setCurrentWorkingDirectory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 906,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 863,
   FQN="(anonymous namespace)::RedirectingFileSystem::setCurrentWorkingDirectory", NM="_ZN12_GLOBAL__N_121RedirectingFileSystem26setCurrentWorkingDirectoryERKN4llvm5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_121RedirectingFileSystem26setCurrentWorkingDirectoryERKN4llvm5TwineE")
  //</editor-fold>
  @Override public std.error_code setCurrentWorkingDirectory(/*const*/ Twine /*&*/ Path)/* override*/ {
    return ExternalFS.$arrow().setCurrentWorkingDirectory(Path);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RedirectingFileSystem::dir_begin">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 910,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 867,
   FQN="(anonymous namespace)::RedirectingFileSystem::dir_begin", NM="_ZN12_GLOBAL__N_121RedirectingFileSystem9dir_beginERKN4llvm5TwineERSt10error_code",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_121RedirectingFileSystem9dir_beginERKN4llvm5TwineERSt10error_code")
  //</editor-fold>
  @Override public directory_iterator dir_begin(/*const*/ Twine /*&*/ Dir, std.error_code /*&*/ EC)/* override*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      ErrorOr<Entry /*P*/ > E = lookupPath(Dir);
      if (!E.$bool()) {
        EC.$assignMove(E.getError());
        return new directory_iterator();
      }
      ErrorOr<Status> S = status(Dir, E.$star());
      if (!S.$bool()) {
        EC.$assignMove(S.getError());
        return new directory_iterator();
      }
      if (!S.$arrow().isDirectory()) {
        EC.$assignMove(new std.error_code(errc.not_a_directory.getValue(), 
                std.system_category()));
        return new directory_iterator();
      }
      
      RedirectingDirectoryEntry /*P*/ D = cast(RedirectingDirectoryEntry.class, E.$star());
      return $c$.clean(new directory_iterator($c$.track(new std.shared_ptr<DirIterImpl>($c$.track(std.make_shared(new VFSFromYamlDirIterImpl(Dir, 
                  /*Deref*/this, D.contents_begin(), D.contents_end(), EC)))))));
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RedirectingFileSystem::setExternalContentsPrefixDir">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 932,
   FQN="(anonymous namespace)::RedirectingFileSystem::setExternalContentsPrefixDir", NM="_ZN12_GLOBAL__N_121RedirectingFileSystem28setExternalContentsPrefixDirEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_121RedirectingFileSystem28setExternalContentsPrefixDirEN4llvm9StringRefE")
  //</editor-fold>
  public void setExternalContentsPrefixDir(StringRef PrefixDir) {
    ExternalContentsPrefixDir.$assignMove(PrefixDir.str());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RedirectingFileSystem::getExternalContentsPrefixDir">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 936,
   FQN="(anonymous namespace)::RedirectingFileSystem::getExternalContentsPrefixDir", NM="_ZNK12_GLOBAL__N_121RedirectingFileSystem28getExternalContentsPrefixDirEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZNK12_GLOBAL__N_121RedirectingFileSystem28getExternalContentsPrefixDirEv")
  //</editor-fold>
  public StringRef getExternalContentsPrefixDir() /*const*/ {
    return new StringRef(ExternalContentsPrefixDir);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RedirectingFileSystem::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 941,
   FQN="(anonymous namespace)::RedirectingFileSystem::dump", NM="_ZNK12_GLOBAL__N_121RedirectingFileSystem4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZNK12_GLOBAL__N_121RedirectingFileSystem4dumpEv")
  //</editor-fold>
  public void dump() /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    for (/*const*/ std.unique_ptr<Entry> /*&*/ Root : Roots)  {
      dumpEntry(Root.get());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RedirectingFileSystem::dumpEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 946,
   FQN="(anonymous namespace)::RedirectingFileSystem::dumpEntry", NM="_ZNK12_GLOBAL__N_121RedirectingFileSystem9dumpEntryEPNS_5EntryEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZNK12_GLOBAL__N_121RedirectingFileSystem9dumpEntryEPNS_5EntryEi")
  //</editor-fold>
  public void dumpEntry(Entry /*P*/ E) /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    dumpEntry(E, 0);
  }
  public void dumpEntry(Entry /*P*/ E, int NumSpaces/*= 0*/) /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    StringRef Name = E.getName();
    for (int i = 0, e = NumSpaces; i < e; ++i)  {
      dbgs().$out(/*KEEP_STR*/$SPACE);
    }
    dbgs().$out(/*KEEP_STR*/$SGL_QUOTE).$out(Name.str().c_str()).$out(/*KEEP_STR*/$SGL_QUOTE).$out(/*KEEP_STR*/$LF);
    if (E.getKind() == EntryKind.EK_Directory) {
      RedirectingDirectoryEntry /*P*/ DE = dyn_cast(RedirectingDirectoryEntry.class, E);
      assert ((DE != null)) : "Should be a directory";
      
      for (std.unique_ptr<Entry> /*&*/ SubEntry : llvm.make_range(DE.contents_begin(), DE.contents_end()))  {
        dumpEntry(SubEntry.get(), NumSpaces + 2);
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RedirectingFileSystem::~RedirectingFileSystem">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 838,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 813,
   FQN="(anonymous namespace)::RedirectingFileSystem::~RedirectingFileSystem", NM="_ZN12_GLOBAL__N_121RedirectingFileSystemD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_121RedirectingFileSystemD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    ExternalContentsPrefixDir.$destroy();
    ExternalFS.$destroy();
    Roots.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  public String toString() {
    return "" + "Roots=" + Roots // NOI18N
              + ", ExternalFS=" + ExternalFS // NOI18N
              + ", ExternalContentsPrefixDir=" + ExternalContentsPrefixDir // NOI18N
              + ", CaseSensitive=" + CaseSensitive // NOI18N
              + ", IsRelativeOverlay=" + IsRelativeOverlay // NOI18N
              + ", UseExternalNames=" + UseExternalNames // NOI18N
              + ", UseCanonicalizedPaths=" + UseCanonicalizedPaths // NOI18N
              + super.toString(); // NOI18N
  }
}
