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

package org.clang.frontend;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.vfs.*;
import org.clang.lex.*;
import org.clang.serialization.*;
import org.clang.frontend.*;
import org.clang.frontend.impl.*;
import org.llvm.support.sys.*;
import static org.clang.frontend.impl.ModuleDependencyCollectorStatics.*;


/// Collects the dependencies for imported modules into a directory.  Users
/// should attach to the AST reader whenever a module is loaded.
//<editor-fold defaultstate="collapsed" desc="clang::ModuleDependencyCollector">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/Utils.h", line = 122,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/Utils.h", old_line = 121,
 FQN="clang::ModuleDependencyCollector", NM="_ZN5clang25ModuleDependencyCollectorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ModuleDependencyCollector.cpp -nm=_ZN5clang25ModuleDependencyCollectorE")
//</editor-fold>
public class ModuleDependencyCollector extends /*public*/ DependencyCollector implements Destructors.ClassWithDestructor {
  private std.string DestDir;
  private boolean HasErrors/* = false*/;
  private StringSet/*<MallocAllocator>*/ Seen;
  private YAMLVFSWriter VFSWriter;
  
  private StringMap<std.string> SymLinkMap;
  
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleDependencyCollector::getRealPath">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ModuleDependencyCollector.cpp", line = 157,
   FQN="clang::ModuleDependencyCollector::getRealPath", NM="_ZN5clang25ModuleDependencyCollector11getRealPathEN4llvm9StringRefERNS1_15SmallVectorImplIcEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ModuleDependencyCollector.cpp -nm=_ZN5clang25ModuleDependencyCollector11getRealPathEN4llvm9StringRefERNS1_15SmallVectorImplIcEE")
  //</editor-fold>
  private boolean getRealPath(StringRef SrcPath, 
             SmallString/*&*/ Result) {
    //JAVA: using namespace llvm::sys;
    SmallString/*256*/ RealPath/*J*/= new SmallString/*256*/(256);
    StringRef FileName = path.filename(/*NO_COPY*/SrcPath);
    std.string Dir = path.parent_path(/*NO_COPY*/SrcPath).str();
    StringMapIterator<std.string> DirWithSymLink = SymLinkMap.find(new StringRef(Dir));
    
    // Use real_path to fix any symbolic link component present in a path.
    // Computing the real path is expensive, cache the search through the
    // parent path directory.
    if (DirWithSymLink.$eq(SymLinkMap.end())) {
      if (!real_path(new StringRef(Dir), RealPath)) {
        return false;
      }
      SymLinkMap.$at(new StringRef(Dir)).$assignMove(RealPath.str().$string());
    } else {
      RealPath.$assign(new StringRef(DirWithSymLink.$arrow().second));
    }
    
    path.append(RealPath, new Twine(FileName));
    Result.swap(RealPath);
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ModuleDependencyCollector::copyToRoot">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ModuleDependencyCollector.cpp", line = 181,
   FQN="clang::ModuleDependencyCollector::copyToRoot", NM="_ZN5clang25ModuleDependencyCollector10copyToRootEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ModuleDependencyCollector.cpp -nm=_ZN5clang25ModuleDependencyCollector10copyToRootEN4llvm9StringRefE")
  //</editor-fold>
  private std.error_code copyToRoot(StringRef Src) {
    //JAVA: using namespace llvm::sys;
    
    // We need an absolute src path to append to the root.
    SmallString/*256*/ AbsoluteSrc = new SmallString/*256*/(new StringRef(Src), 256);
    fs.make_absolute(AbsoluteSrc);
    // Canonicalize src to a native path to avoid mixed separator styles.
    path.__native(AbsoluteSrc);
    // Remove redundant leading "./" pieces and consecutive separators.
    AbsoluteSrc.$assign(path.remove_leading_dotslash(AbsoluteSrc.$StringRef()));
    
    // Canonicalize the source path by removing "..", "." components.
    SmallString/*256*/ CanonicalPath = new SmallString/*256*/(AbsoluteSrc);
    path.remove_dots(CanonicalPath, /*remove_dot_dot=*/ true);
    
    // If a ".." component is present after a symlink component, remove_dots may
    // lead to the wrong real destination path. Let the source be canonicalized
    // like that but make sure we always use the real path for the destination.
    SmallString/*256*/ RealPath/*J*/= new SmallString/*256*/(256);
    if (!getRealPath(AbsoluteSrc.$StringRef(), RealPath)) {
      RealPath.$assign(CanonicalPath);
    }
    SmallString/*256*/ Dest = new SmallString/*256*/(getDest(), 256);
    path.append(Dest, new Twine(path.relative_path(RealPath.$StringRef())));
    {
      
      // Copy the file into place.
      std.error_code EC = fs.create_directories(new Twine(path.parent_path(Dest.$StringRef())), 
          /*IgnoreExisting=*/ true);
      if (EC.$bool()) {
        return EC;
      }
    }
    {
      std.error_code EC = fs.copy_file(new Twine(RealPath), new Twine(Dest));
      if (EC.$bool()) {
        return EC;
      }
    }
    
    // Always map a canonical src path to its real path into the YAML, by doing
    // this we map different virtual src paths to the same entry in the VFS
    // overlay, which is a way to emulate symlink inside the VFS; this is also
    // needed for correctness, not doing that can lead to module redifinition
    // errors.
    addFileMapping(CanonicalPath.$StringRef(), Dest.$StringRef());
    return new std.error_code();
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleDependencyCollector::getDest">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/Utils.h", line = 133,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/Utils.h", old_line = 128,
   FQN="clang::ModuleDependencyCollector::getDest", NM="_ZN5clang25ModuleDependencyCollector7getDestEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ModuleDependencyCollector.cpp -nm=_ZN5clang25ModuleDependencyCollector7getDestEv")
  //</editor-fold>
  public StringRef getDest() {
    return new StringRef(DestDir);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ModuleDependencyCollector::insertSeen">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/Utils.h", line = 134,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/Utils.h", old_line = 129,
   FQN="clang::ModuleDependencyCollector::insertSeen", NM="_ZN5clang25ModuleDependencyCollector10insertSeenEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ModuleDependencyCollector.cpp -nm=_ZN5clang25ModuleDependencyCollector10insertSeenEN4llvm9StringRefE")
  //</editor-fold>
  public boolean insertSeen(StringRef Filename) {
    return Seen.insert(/*NO_COPY*/Filename).second;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ModuleDependencyCollector::addFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ModuleDependencyCollector.cpp", line = 221,
   FQN="clang::ModuleDependencyCollector::addFile", NM="_ZN5clang25ModuleDependencyCollector7addFileEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ModuleDependencyCollector.cpp -nm=_ZN5clang25ModuleDependencyCollector7addFileEN4llvm9StringRefE")
  //</editor-fold>
  public void addFile(StringRef Filename) {
    if (insertSeen(new StringRef(Filename))) {
      if (copyToRoot(new StringRef(Filename)).$bool()) {
        HasErrors = true;
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ModuleDependencyCollector::addFileMapping">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/Utils.h", line = 136,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/Utils.h", old_line = 131,
   FQN="clang::ModuleDependencyCollector::addFileMapping", NM="_ZN5clang25ModuleDependencyCollector14addFileMappingEN4llvm9StringRefES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ModuleDependencyCollector.cpp -nm=_ZN5clang25ModuleDependencyCollector14addFileMappingEN4llvm9StringRefES2_")
  //</editor-fold>
  public void addFileMapping(StringRef VPath, StringRef RPath) {
    VFSWriter.addFileMapping(new StringRef(VPath), new StringRef(RPath));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleDependencyCollector::attachToPreprocessor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ModuleDependencyCollector.cpp", line = 105,
   FQN="clang::ModuleDependencyCollector::attachToPreprocessor", NM="_ZN5clang25ModuleDependencyCollector20attachToPreprocessorERNS_12PreprocessorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ModuleDependencyCollector.cpp -nm=_ZN5clang25ModuleDependencyCollector20attachToPreprocessorERNS_12PreprocessorE")
  //</editor-fold>
  @Override public void attachToPreprocessor(Preprocessor /*&*/ PP)/* override*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      PP.getHeaderSearchInfo().getModuleMap().addModuleMapCallbacks($c$.track(new std.unique_ptr<ModuleMapCallbacks>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new ModuleDependencyMMCallbacks(/*Deref*/this)))))); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ModuleDependencyCollector::attachToASTReader">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ModuleDependencyCollector.cpp", line = 101,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ModuleDependencyCollector.cpp", old_line = 40,
   FQN="clang::ModuleDependencyCollector::attachToASTReader", NM="_ZN5clang25ModuleDependencyCollector17attachToASTReaderERNS_9ASTReaderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ModuleDependencyCollector.cpp -nm=_ZN5clang25ModuleDependencyCollector17attachToASTReaderERNS_9ASTReaderE")
  //</editor-fold>
  @Override public void attachToASTReader(ASTReader /*&*/ R)/* override*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      R.addListener($c$.track(new std.unique_ptr<ASTReaderListener>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new ModuleDependencyListener(/*Deref*/this)))))); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleDependencyCollector::writeFileMap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ModuleDependencyCollector.cpp", line = 128,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ModuleDependencyCollector.cpp", old_line = 44,
   FQN="clang::ModuleDependencyCollector::writeFileMap", NM="_ZN5clang25ModuleDependencyCollector12writeFileMapEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ModuleDependencyCollector.cpp -nm=_ZN5clang25ModuleDependencyCollector12writeFileMapEv")
  //</editor-fold>
  public void writeFileMap() {
    raw_fd_ostream OS = null;
    try {
      if (Seen.empty()) {
        return;
      }
      
      StringRef VFSDir = getDest();
      
      // Default to use relative overlay directories in the VFS yaml file. This
      // allows crash reproducer scripts to work across machines.
      VFSWriter.setOverlayDir(new StringRef(VFSDir));
      
      // Explicitly set case sensitivity for the YAML writer. For that, find out
      // the sensitivity at the path where the headers all collected to.
      VFSWriter.setCaseSensitivity(isCaseSensitivePath(new StringRef(VFSDir)));
      
      // Do not rely on real path names when executing the crash reproducer scripts
      // since we only want to actually use the files we have on the VFS cache.
      VFSWriter.setUseExternalNames(false);
      
      std.error_code EC/*J*/= new std.error_code();
      SmallString/*256*/ YAMLPath = new SmallString/*256*/(new StringRef(VFSDir), 256);
      path.append(YAMLPath, new Twine(/*KEEP_STR*/"vfs.yaml"));
      OS/*J*/= new raw_fd_ostream(YAMLPath.$StringRef(), EC, fs.OpenFlags.F_Text);
      if (EC.$bool()) {
        HasErrors = true;
        return;
      }
      VFSWriter.write(OS);
    } finally {
      if (OS != null) { OS.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ModuleDependencyCollector::hasErrors">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/Utils.h", line = 144,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/Utils.h", old_line = 137,
   FQN="clang::ModuleDependencyCollector::hasErrors", NM="_ZN5clang25ModuleDependencyCollector9hasErrorsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ModuleDependencyCollector.cpp -nm=_ZN5clang25ModuleDependencyCollector9hasErrorsEv")
  //</editor-fold>
  public boolean hasErrors() {
    return HasErrors;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ModuleDependencyCollector::ModuleDependencyCollector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/Utils.h", line = 145,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/Utils.h", old_line = 138,
   FQN="clang::ModuleDependencyCollector::ModuleDependencyCollector", NM="_ZN5clang25ModuleDependencyCollectorC1ESs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ModuleDependencyCollector.cpp -nm=_ZN5clang25ModuleDependencyCollectorC1ESs")
  //</editor-fold>
  public ModuleDependencyCollector(std.string DestDir) {
    // : DependencyCollector(), DestDir(std::move(DestDir)), HasErrors(false), Seen(), VFSWriter(), SymLinkMap() 
    //START JInit
    super();
    this.DestDir = new std.string(JD$Move.INSTANCE, std.move(DestDir));
    /*InClass*/this.HasErrors = false;
    this.Seen = new StringSet/*<MallocAllocator>*/();
    this.VFSWriter = new YAMLVFSWriter();
    this.SymLinkMap = new StringMap<std.string>(std.string.EMPTY);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ModuleDependencyCollector::~ModuleDependencyCollector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/Utils.h", line = 147,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/Utils.h", old_line = 140,
   FQN="clang::ModuleDependencyCollector::~ModuleDependencyCollector", NM="_ZN5clang25ModuleDependencyCollectorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ModuleDependencyCollector.cpp -nm=_ZN5clang25ModuleDependencyCollectorD0Ev")
  //</editor-fold>
  @Override public void $destroy() {
    writeFileMap();
    //START JDestroy
    SymLinkMap.$destroy();
    VFSWriter.$destroy();
    Seen.$destroy();
    DestDir.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "DestDir=" + DestDir // NOI18N
              + ", HasErrors=" + HasErrors // NOI18N
              + ", Seen=" + Seen // NOI18N
              + ", VFSWriter=" + VFSWriter // NOI18N
              + ", SymLinkMap=" + SymLinkMap // NOI18N
              + super.toString(); // NOI18N
  }
}
