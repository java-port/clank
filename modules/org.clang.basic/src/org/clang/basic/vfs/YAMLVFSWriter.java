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

package org.clang.basic.vfs;

import org.clank.java.*;
import org.clank.support.*;
import static org.clank.java.std.*;
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.vfs.*;
import org.clang.basic.impl.JSONWriter;
import static org.clang.basic.impl.VirtualFileSystemStatics.*;
import org.llvm.support.sys.path;

//<editor-fold defaultstate="collapsed" desc="clang::vfs::YAMLVFSWriter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", line = 338,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", old_line = 323,
 FQN="clang::vfs::YAMLVFSWriter", NM="_ZN5clang3vfs13YAMLVFSWriterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs13YAMLVFSWriterE")
//</editor-fold>
public class YAMLVFSWriter implements Destructors.ClassWithDestructor {
  private std.vector<YAMLVFSEntry> Mappings;
  private OptionalBool IsCaseSensitive;
  private OptionalBool IsOverlayRelative;
  private OptionalBool UseExternalNames;
  private std.string OverlayDir;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::vfs::YAMLVFSWriter::YAMLVFSWriter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", line = 346,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", old_line = 328,
   FQN="clang::vfs::YAMLVFSWriter::YAMLVFSWriter", NM="_ZN5clang3vfs13YAMLVFSWriterC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs13YAMLVFSWriterC1Ev")
  //</editor-fold>
  public YAMLVFSWriter() {
    /* : Mappings(), IsCaseSensitive(), IsOverlayRelative(), UseExternalNames(), OverlayDir()*/ 
    //START JInit
    this.Mappings = new std.vector<YAMLVFSEntry>(YAMLVFSEntry.EMPTY);
    this.IsCaseSensitive = new OptionalBool();
    this.IsOverlayRelative = new OptionalBool();
    this.UseExternalNames = new OptionalBool();
    this.OverlayDir = new std.string();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::vfs::YAMLVFSWriter::addFileMapping">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 1599,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 1389,
   FQN="clang::vfs::YAMLVFSWriter::addFileMapping", NM="_ZN5clang3vfs13YAMLVFSWriter14addFileMappingEN4llvm9StringRefES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs13YAMLVFSWriter14addFileMappingEN4llvm9StringRefES3_")
  //</editor-fold>
  public void addFileMapping(StringRef VirtualPath, StringRef RealPath) {
    assert (path.is_absolute(new Twine(VirtualPath))) : "virtual path not absolute";
    assert (path.is_absolute(new Twine(RealPath))) : "real path not absolute";
    assert (!pathHasTraversal(/*NO_COPY*/VirtualPath)) : "path traversal is not supported";
    Mappings.emplace_back(new YAMLVFSEntry(VirtualPath, RealPath));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::vfs::YAMLVFSWriter::setCaseSensitivity">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", line = 348,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", old_line = 330,
   FQN="clang::vfs::YAMLVFSWriter::setCaseSensitivity", NM="_ZN5clang3vfs13YAMLVFSWriter18setCaseSensitivityEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs13YAMLVFSWriter18setCaseSensitivityEb")
  //</editor-fold>
  public void setCaseSensitivity(boolean CaseSensitive) {
    IsCaseSensitive.$assign(/*KEEP_BOOL*/CaseSensitive);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::vfs::YAMLVFSWriter::setUseExternalNames">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", line = 351,
   FQN="clang::vfs::YAMLVFSWriter::setUseExternalNames", NM="_ZN5clang3vfs13YAMLVFSWriter19setUseExternalNamesEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs13YAMLVFSWriter19setUseExternalNamesEb")
  //</editor-fold>
  public void setUseExternalNames(boolean UseExtNames) {
    UseExternalNames.$assign(/*KEEP_BOOL*/UseExtNames);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::vfs::YAMLVFSWriter::setOverlayDir">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", line = 354,
   FQN="clang::vfs::YAMLVFSWriter::setOverlayDir", NM="_ZN5clang3vfs13YAMLVFSWriter13setOverlayDirEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs13YAMLVFSWriter13setOverlayDirEN4llvm9StringRefE")
  //</editor-fold>
  public void setOverlayDir(StringRef OverlayDirectory) {
    IsOverlayRelative.$assign(/*KEEP_BOOL*/true);
    OverlayDir.assign(OverlayDirectory.str());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::vfs::YAMLVFSWriter::write">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 1744,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 1504,
   FQN="clang::vfs::YAMLVFSWriter::write", NM="_ZN5clang3vfs13YAMLVFSWriter5writeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs13YAMLVFSWriter5writeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void write(raw_ostream /*&*/ OS) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      std.sort(Mappings.begin(), Mappings.end(), 
           (LHS, RHS) -> 
            {
              return $less_string$C(LHS.VPath, RHS.VPath);
            }
);
      
      $c$.track(new JSONWriter(OS)).write(new ArrayRef<YAMLVFSEntry>(Mappings), new OptionalBool(UseExternalNames), new OptionalBool(IsCaseSensitive), 
          new OptionalBool(IsOverlayRelative), new StringRef(OverlayDir)); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::vfs::YAMLVFSWriter::~YAMLVFSWriter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", line = 338,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", old_line = 323,
   FQN="clang::vfs::YAMLVFSWriter::~YAMLVFSWriter", NM="_ZN5clang3vfs13YAMLVFSWriterD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp -nm=_ZN5clang3vfs13YAMLVFSWriterD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    OverlayDir.$destroy();
    UseExternalNames.$destroy();
    IsOverlayRelative.$destroy();
    IsCaseSensitive.$destroy();
    Mappings.$destroy();
    //END JDestroy
  }


  
  public String toString() {
    return "" + "Mappings=" + Mappings // NOI18N
              + ", IsCaseSensitive=" + IsCaseSensitive // NOI18N
              + ", IsOverlayRelative=" + IsOverlayRelative // NOI18N
              + ", UseExternalNames=" + UseExternalNames // NOI18N
              + ", OverlayDir=" + OverlayDir; // NOI18N
  }
}
