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

package org.clang.sema;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clang.basic.*;


/// Describes whether we've seen any nullability information for the given
/// file.
//<editor-fold defaultstate="collapsed" desc="clang::FileNullability">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 220,
 FQN="clang::FileNullability", NM="_ZN5clang15FileNullabilityE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/FrontendActions.cpp -nm=_ZN5clang15FileNullabilityE")
//</editor-fold>
public class/*struct*/ FileNullability implements NativePOD<FileNullability> {
  /// The first pointer declarator (of any pointer kind) in the file that does
  /// not have a corresponding nullability annotation.
  public SourceLocation PointerLoc;
  
  /// Which kind of pointer declarator we saw.
  public byte/*uint8_t*/ PointerKind;
  
  /// Whether we saw any type nullability annotations in the given file.
  public boolean SawTypeNullability/* = false*/;
  //<editor-fold defaultstate="collapsed" desc="clang::FileNullability::FileNullability">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 220,
   FQN="clang::FileNullability::FileNullability", NM="_ZN5clang15FileNullabilityC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/FrontendActions.cpp -nm=_ZN5clang15FileNullabilityC1ERKS0_")
  //</editor-fold>
  public /*inline*/ FileNullability(final /*const*/ FileNullability /*&*/ $Prm0) {
    // : PointerLoc(.PointerLoc), PointerKind(.PointerKind), SawTypeNullability(.SawTypeNullability) 
    //START JInit
    this.PointerLoc = new SourceLocation($Prm0.PointerLoc);
    this.PointerKind = $Prm0.PointerKind;
    this.SawTypeNullability = $Prm0.SawTypeNullability;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FileNullability::FileNullability">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 220,
   FQN="clang::FileNullability::FileNullability", NM="_ZN5clang15FileNullabilityC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/FrontendActions.cpp -nm=_ZN5clang15FileNullabilityC1EOS0_")
  //</editor-fold>
  public /*inline*/ FileNullability(JD$Move _dparam, final FileNullability /*&&*/$Prm0) {
    // : PointerLoc(static_cast<FileNullability &&>().PointerLoc), PointerKind(static_cast<FileNullability &&>().PointerKind), SawTypeNullability(static_cast<FileNullability &&>().SawTypeNullability) 
    //START JInit
    this.PointerLoc = new SourceLocation(JD$Move.INSTANCE, $Prm0.PointerLoc);
    this.PointerKind = $Prm0.PointerKind;
    this.SawTypeNullability = $Prm0.SawTypeNullability;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FileNullability::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 220,
   FQN="clang::FileNullability::operator=", NM="_ZN5clang15FileNullabilityaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/FrontendActions.cpp -nm=_ZN5clang15FileNullabilityaSERKS0_")
  //</editor-fold>
  public /*inline*/ FileNullability /*&*/ $assign(final /*const*/ FileNullability /*&*/ $Prm0) {
    this.PointerLoc.$assign($Prm0.PointerLoc);
    this.PointerKind = $Prm0.PointerKind;
    this.SawTypeNullability = $Prm0.SawTypeNullability;
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FileNullability::FileNullability">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 220,
   FQN="clang::FileNullability::FileNullability", NM="_ZN5clang15FileNullabilityC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/FrontendActions.cpp -nm=_ZN5clang15FileNullabilityC1Ev")
  //</editor-fold>
  public /*inline*/ FileNullability() {
    // : PointerLoc(), SawTypeNullability(false) 
    //START JInit
    this.PointerLoc = new SourceLocation();
    /*InClass*/this.SawTypeNullability = false;
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override public FileNullability clone() {
    return new FileNullability(this);
  }

  @Override
  public boolean $eq(FileNullability other) {
    if (this == other) {
      return true;
    }
    if (other == null) {
      return false;
    }
    if (this.PointerKind != other.PointerKind) {
      return false;
    }
    if (this.SawTypeNullability != other.SawTypeNullability) {
      return false;
    }
    if (this.PointerLoc.$noteq(other.PointerLoc)) {
      return false;
    }
    return true;
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "PointerLoc=" + PointerLoc // NOI18N
              + ", PointerKind=" + $uchar2uint(PointerKind) // NOI18N
              + ", SawTypeNullability=" + SawTypeNullability; // NOI18N
  }
}
