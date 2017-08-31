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
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.frontend.*;


/// \brief An input file for the front end.
//<editor-fold defaultstate="collapsed" desc="clang::FrontendInputFile">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendOptions.h", line = 84,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendOptions.h", old_line = 82,
 FQN="clang::FrontendInputFile", NM="_ZN5clang17FrontendInputFileE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZN5clang17FrontendInputFileE")
//</editor-fold>
public class FrontendInputFile implements Destructors.ClassWithDestructor, NativeCloneable<FrontendInputFile> {
  /// \brief The file name, or "-" to read from standard input.
  private std.string File;
  
  private MemoryBuffer /*P*/ Buffer;
  
  /// \brief The kind of input, e.g., C source, AST file, LLVM IR.
  private InputKind Kind;
  
  /// \brief Whether we're dealing with a 'system' input (vs. a 'user' input).
  private boolean IsSystem;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::FrontendInputFile::FrontendInputFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendOptions.h", line = 97,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendOptions.h", old_line = 95,
   FQN="clang::FrontendInputFile::FrontendInputFile", NM="_ZN5clang17FrontendInputFileC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZN5clang17FrontendInputFileC1Ev")
  //</editor-fold>
  public FrontendInputFile() {
    // : File(), Buffer(null), Kind(IK_None), IsSystem(false) 
    //START JInit
    this.File = new std.string();
    this.Buffer = null;
    this.Kind = InputKind.IK_None;
    this.IsSystem = false;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FrontendInputFile::FrontendInputFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendOptions.h", line = 98,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendOptions.h", old_line = 96,
   FQN="clang::FrontendInputFile::FrontendInputFile", NM="_ZN5clang17FrontendInputFileC1EN4llvm9StringRefENS_9InputKindEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZN5clang17FrontendInputFileC1EN4llvm9StringRefENS_9InputKindEb")
  //</editor-fold>
  public FrontendInputFile(StringRef File, InputKind Kind) {
    this(File, Kind, false);
  }
  public FrontendInputFile(StringRef File, InputKind Kind, boolean IsSystem/*= false*/) {
    // : File(File.str()), Buffer(null), Kind(Kind), IsSystem(IsSystem) 
    //START JInit
    this.File = File.str();
    this.Buffer = null;
    this.Kind = Kind;
    this.IsSystem = IsSystem;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FrontendInputFile::FrontendInputFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendOptions.h", line = 100,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendOptions.h", old_line = 98,
   FQN="clang::FrontendInputFile::FrontendInputFile", NM="_ZN5clang17FrontendInputFileC1EPN4llvm12MemoryBufferENS_9InputKindEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZN5clang17FrontendInputFileC1EPN4llvm12MemoryBufferENS_9InputKindEb")
  //</editor-fold>
  public FrontendInputFile(MemoryBuffer /*P*/ buffer, InputKind Kind) {
    this(buffer, Kind, 
      false);
  }
  public FrontendInputFile(MemoryBuffer /*P*/ buffer, InputKind Kind, 
      boolean IsSystem/*= false*/) {
    // : File(), Buffer(buffer), Kind(Kind), IsSystem(IsSystem) 
    //START JInit
    this.File = new std.string();
    this.Buffer = buffer;
    this.Kind = Kind;
    this.IsSystem = IsSystem;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FrontendInputFile::getKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendOptions.h", line = 104,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendOptions.h", old_line = 102,
   FQN="clang::FrontendInputFile::getKind", NM="_ZNK5clang17FrontendInputFile7getKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZNK5clang17FrontendInputFile7getKindEv")
  //</editor-fold>
  public InputKind getKind() /*const*/ {
    return Kind;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FrontendInputFile::isSystem">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendOptions.h", line = 105,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendOptions.h", old_line = 103,
   FQN="clang::FrontendInputFile::isSystem", NM="_ZNK5clang17FrontendInputFile8isSystemEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZNK5clang17FrontendInputFile8isSystemEv")
  //</editor-fold>
  public boolean isSystem() /*const*/ {
    return IsSystem;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FrontendInputFile::isEmpty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendOptions.h", line = 107,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendOptions.h", old_line = 105,
   FQN="clang::FrontendInputFile::isEmpty", NM="_ZNK5clang17FrontendInputFile7isEmptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZNK5clang17FrontendInputFile7isEmptyEv")
  //</editor-fold>
  public boolean isEmpty() /*const*/ {
    return File.empty() && Buffer == null;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FrontendInputFile::isFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendOptions.h", line = 108,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendOptions.h", old_line = 106,
   FQN="clang::FrontendInputFile::isFile", NM="_ZNK5clang17FrontendInputFile6isFileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZNK5clang17FrontendInputFile6isFileEv")
  //</editor-fold>
  public boolean isFile() /*const*/ {
    return !isBuffer();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FrontendInputFile::isBuffer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendOptions.h", line = 109,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendOptions.h", old_line = 107,
   FQN="clang::FrontendInputFile::isBuffer", NM="_ZNK5clang17FrontendInputFile8isBufferEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZNK5clang17FrontendInputFile8isBufferEv")
  //</editor-fold>
  public boolean isBuffer() /*const*/ {
    return Buffer != null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FrontendInputFile::getFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendOptions.h", line = 111,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendOptions.h", old_line = 109,
   FQN="clang::FrontendInputFile::getFile", NM="_ZNK5clang17FrontendInputFile7getFileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZNK5clang17FrontendInputFile7getFileEv")
  //</editor-fold>
  public StringRef getFile() /*const*/ {
    assert (isFile());
    return new StringRef(File);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FrontendInputFile::getBuffer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendOptions.h", line = 115,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendOptions.h", old_line = 113,
   FQN="clang::FrontendInputFile::getBuffer", NM="_ZNK5clang17FrontendInputFile9getBufferEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZNK5clang17FrontendInputFile9getBufferEv")
  //</editor-fold>
  public MemoryBuffer /*P*/ getBuffer() /*const*/ {
    assert (isBuffer());
    return Buffer;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FrontendInputFile::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendOptions.h", line = 84,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendOptions.h", old_line = 82,
   FQN="clang::FrontendInputFile::operator=", NM="_ZN5clang17FrontendInputFileaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZN5clang17FrontendInputFileaSERKS0_")
  //</editor-fold>
  public /*inline*/ FrontendInputFile /*&*/ $assign(/*const*/ FrontendInputFile /*&*/ $Prm0) {
    this.File.$assign($Prm0.File);
    this.Buffer = $Prm0.Buffer;
    this.Kind = $Prm0.Kind;
    this.IsSystem = $Prm0.IsSystem;
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FrontendInputFile::~FrontendInputFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendOptions.h", line = 84,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendOptions.h", old_line = 82,
   FQN="clang::FrontendInputFile::~FrontendInputFile", NM="_ZN5clang17FrontendInputFileD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZN5clang17FrontendInputFileD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    File.$destroy();
    //END JDestroy
  }


  //<editor-fold defaultstate="collapsed" desc="clang::FrontendInputFile::FrontendInputFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendOptions.h", line = 84,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendOptions.h", old_line = 82,
   FQN="clang::FrontendInputFile::FrontendInputFile", NM="_ZN5clang17FrontendInputFileC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/ModelInjector.cpp -nm=_ZN5clang17FrontendInputFileC1ERKS0_")
  //</editor-fold>
  public /*inline*/ FrontendInputFile(/*const*/ FrontendInputFile /*&*/ $Prm0) {
    // : File(.File), Buffer(.Buffer), Kind(.Kind), IsSystem(.IsSystem) 
    //START JInit
    this.File = new std.string($Prm0.File);
    this.Buffer = $Prm0.Buffer;
    this.Kind = $Prm0.Kind;
    this.IsSystem = $Prm0.IsSystem;
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="clang::FrontendInputFile::FrontendInputFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendOptions.h", line = 84,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendOptions.h", old_line = 82,
   FQN="clang::FrontendInputFile::FrontendInputFile", NM="_ZN5clang17FrontendInputFileC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/ModelInjector.cpp -nm=_ZN5clang17FrontendInputFileC1EOS0_")
  //</editor-fold>
  public /*inline*/ FrontendInputFile(JD$Move _dparam, FrontendInputFile /*&&*/$Prm0) {
    // : File(static_cast<FrontendInputFile &&>().File), Buffer(static_cast<FrontendInputFile &&>().Buffer), Kind(static_cast<FrontendInputFile &&>().Kind), IsSystem(static_cast<FrontendInputFile &&>().IsSystem) 
    //START JInit
    this.File = new std.string(JD$Move.INSTANCE, $Prm0.File);
    this.Buffer = $Prm0.Buffer;
    this.Kind = $Prm0.Kind;
    this.IsSystem = $Prm0.IsSystem;
    //END JInit
  }

  @Override public FrontendInputFile clone() { return new FrontendInputFile(this); }
  
  @Override public String toString() {
    return "" + "File=" + File // NOI18N
              + ", Buffer=" + Buffer // NOI18N
              + ", Kind=" + Kind // NOI18N
              + ", IsSystem=" + IsSystem; // NOI18N
  }
}
