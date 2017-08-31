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

package org.clang.rewrite.core;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;


//===--------------------------------------------------------------------===//
// RopePiece Class
//===--------------------------------------------------------------------===//

/// RopePiece - This class represents a view into a RopeRefCountString object.
/// This allows references to string data to be efficiently chopped up and
/// moved around without having to push around the string data itself.
///
/// For example, we could have a 1M RopePiece and want to insert something
/// into the middle of it.  To do this, we split it into two RopePiece objects
/// that both refer to the same underlying RopeRefCountString (just with
/// different offsets) which is a nice constant time operation.
//<editor-fold defaultstate="collapsed" desc="clang::RopePiece">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*POD*/,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/RewriteRope.h", line = 59,
 FQN="clang::RopePiece", NM="_ZN5clang9RopePieceE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZN5clang9RopePieceE")
//</editor-fold>
public class/*struct*/ RopePiece implements Destructors.ClassWithDestructor, NativePOD<RopePiece> {
  public IntrusiveRefCntPtr<RopeRefCountString> StrData;
  public /*uint*/int StartOffs;
  public /*uint*/int EndOffs;
  
  //<editor-fold defaultstate="collapsed" desc="clang::RopePiece::RopePiece">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/RewriteRope.h", line = 64,
   FQN="clang::RopePiece::RopePiece", NM="_ZN5clang9RopePieceC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZN5clang9RopePieceC1Ev")
  //</editor-fold>
  public RopePiece() {
    // : StrData(null), StartOffs(0), EndOffs(0) 
    //START JInit
    this.StrData = new IntrusiveRefCntPtr<RopeRefCountString>((RopeRefCountString /*P*/ )null);
    this.StartOffs = 0;
    this.EndOffs = 0;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::RopePiece::RopePiece">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/RewriteRope.h", line = 66,
   FQN="clang::RopePiece::RopePiece", NM="_ZN5clang9RopePieceC1EN4llvm18IntrusiveRefCntPtrINS_18RopeRefCountStringEEEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZN5clang9RopePieceC1EN4llvm18IntrusiveRefCntPtrINS_18RopeRefCountStringEEEjj")
  //</editor-fold>
  public RopePiece(IntrusiveRefCntPtr<RopeRefCountString> Str, /*uint*/int Start, 
      /*uint*/int End) {
    // : StrData(std::move(Str)), StartOffs(Start), EndOffs(End) 
    //START JInit
    this.StrData = new IntrusiveRefCntPtr<RopeRefCountString>(JD$Move.INSTANCE, std.move(Str));
    this.StartOffs = Start;
    this.EndOffs = End;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::RopePiece::operator[]">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/RewriteRope.h", line = 70,
   FQN="clang::RopePiece::operator[]", NM="_ZNK5clang9RopePieceixEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZNK5clang9RopePieceixEj")
  //</editor-fold>
  public /*const*/char$ref/*char &*/ $at$Const(/*uint*/int Offset) /*const*/ {
    return StrData.$arrow().Data.$add(Offset + StartOffs).star$ref();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::RopePiece::operator[]">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/RewriteRope.h", line = 73,
   FQN="clang::RopePiece::operator[]", NM="_ZN5clang9RopePieceixEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZN5clang9RopePieceixEj")
  //</editor-fold>
  public char$ref/*char &*/ $at(/*uint*/int Offset) {
    return StrData.$arrow().Data.$add(Offset + StartOffs).star$ref();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::RopePiece::size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/RewriteRope.h", line = 77,
   FQN="clang::RopePiece::size", NM="_ZNK5clang9RopePiece4sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZNK5clang9RopePiece4sizeEv")
  //</editor-fold>
  public /*uint*/int size() /*const*/ {
    return EndOffs - StartOffs;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::RopePiece::RopePiece">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/RewriteRope.h", line = 59,
   FQN="clang::RopePiece::RopePiece", NM="_ZN5clang9RopePieceC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZN5clang9RopePieceC1EOS0_")
  //</editor-fold>
  public /*inline*/ RopePiece(JD$Move _dparam, RopePiece /*&&*/$Prm0) {
    // : StrData(static_cast<RopePiece &&>().StrData), StartOffs(static_cast<RopePiece &&>().StartOffs), EndOffs(static_cast<RopePiece &&>().EndOffs) 
    //START JInit
    this.StrData = new IntrusiveRefCntPtr<RopeRefCountString>(JD$Move.INSTANCE, $Prm0.StrData);
    this.StartOffs = $Prm0.StartOffs;
    this.EndOffs = $Prm0.EndOffs;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::RopePiece::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/RewriteRope.h", line = 59,
   FQN="clang::RopePiece::operator=", NM="_ZN5clang9RopePieceaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZN5clang9RopePieceaSEOS0_")
  //</editor-fold>
  public /*inline*/ RopePiece /*&*/ $assignMove(RopePiece /*&&*/$Prm0) {
    this.StrData.$assign(new IntrusiveRefCntPtr<RopeRefCountString>(JD$Move.INSTANCE, $Prm0.StrData));
    this.StartOffs = $Prm0.StartOffs;
    this.EndOffs = $Prm0.EndOffs;
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::RopePiece::~RopePiece">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/RewriteRope.h", line = 59,
   FQN="clang::RopePiece::~RopePiece", NM="_ZN5clang9RopePieceD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZN5clang9RopePieceD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    StrData.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="clang::RopePiece::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/RewriteRope.h", line = 59,
   FQN="clang::RopePiece::operator=", NM="_ZN5clang9RopePieceaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/RewriteRope.cpp -nm=_ZN5clang9RopePieceaSERKS0_")
  //</editor-fold>
  public /*inline*/ RopePiece /*&*/ $assign(/*const*/ RopePiece /*&*/ $Prm0) {
    this.StrData.$assign(new IntrusiveRefCntPtr<RopeRefCountString>($Prm0.StrData));
    this.StartOffs = $Prm0.StartOffs;
    this.EndOffs = $Prm0.EndOffs;
    return /*Deref*/this;
  }

  
  @Override public String toString() {
    return "" + "StrData=" + StrData // NOI18N
              + ", StartOffs=" + StartOffs // NOI18N
              + ", EndOffs=" + EndOffs; // NOI18N
  }

  @Override
  public RopePiece clone() {
    return new RopePiece(new IntrusiveRefCntPtr<RopeRefCountString>(this.StrData), this.StartOffs, this.EndOffs);
  }
}
