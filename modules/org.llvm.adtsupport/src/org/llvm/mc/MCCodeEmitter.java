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

package org.llvm.mc;

import org.clank.support.*;
import org.llvm.support.*;
import org.llvm.adt.aliases.*;


/// MCCodeEmitter - Generic instruction encoding interface.
//<editor-fold defaultstate="collapsed" desc="llvm::MCCodeEmitter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCCodeEmitter.h", line = 23,
 FQN="llvm::MCCodeEmitter", NM="_ZN4llvm13MCCodeEmitterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeEmitter.cpp -nm=_ZN4llvm13MCCodeEmitterE")
//</editor-fold>
public abstract class MCCodeEmitter implements Destructors.ClassWithDestructor {
/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MCCodeEmitter::MCCodeEmitter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCCodeEmitter.h", line = 25,
   FQN="llvm::MCCodeEmitter::MCCodeEmitter", NM="_ZN4llvm13MCCodeEmitterC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeEmitter.cpp -nm=_ZN4llvm13MCCodeEmitterC1ERKS0_")
  //</editor-fold>
  protected/*private*/ MCCodeEmitter(final /*const*/ MCCodeEmitter /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::MCCodeEmitter::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCCodeEmitter.h", line = 26,
   FQN="llvm::MCCodeEmitter::operator=", NM="_ZN4llvm13MCCodeEmitteraSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeEmitter.cpp -nm=_ZN4llvm13MCCodeEmitteraSERKS0_")
  //</editor-fold>
  protected/*private*/ void $assign(final /*const*/ MCCodeEmitter /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

/*protected:*/
  // Can only create subclasses.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCCodeEmitter::MCCodeEmitter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCCodeEmitter.cpp", line = 14,
   FQN="llvm::MCCodeEmitter::MCCodeEmitter", NM="_ZN4llvm13MCCodeEmitterC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeEmitter.cpp -nm=_ZN4llvm13MCCodeEmitterC1Ev")
  //</editor-fold>
  protected MCCodeEmitter() {
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MCCodeEmitter::~MCCodeEmitter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCCodeEmitter.cpp", line = 17,
   FQN="llvm::MCCodeEmitter::~MCCodeEmitter", NM="_ZN4llvm13MCCodeEmitterD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeEmitter.cpp -nm=_ZN4llvm13MCCodeEmitterD0Ev")
  //</editor-fold>
  public void $destroy() {
  }

  
  /// Lifetime management
  //<editor-fold defaultstate="collapsed" desc="llvm::MCCodeEmitter::reset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCCodeEmitter.h", line = 35,
   FQN="llvm::MCCodeEmitter::reset", NM="_ZN4llvm13MCCodeEmitter5resetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeEmitter.cpp -nm=_ZN4llvm13MCCodeEmitter5resetEv")
  //</editor-fold>
  public /*virtual*/ void reset() {
  }

  
  /// EncodeInstruction - Encode the given \p Inst to bytes on the output
  /// stream \p OS.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCCodeEmitter::encodeInstruction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCCodeEmitter.h", line = 39,
   FQN="llvm::MCCodeEmitter::encodeInstruction", NM="_ZNK4llvm13MCCodeEmitter17encodeInstructionERKNS_6MCInstERNS_11raw_ostreamERNS_15SmallVectorImplINS_7MCFixupEEERKNS_15MCSubtargetInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeEmitter.cpp -nm=_ZNK4llvm13MCCodeEmitter17encodeInstructionERKNS_6MCInstERNS_11raw_ostreamERNS_15SmallVectorImplINS_7MCFixupEEERKNS_15MCSubtargetInfoE")
  //</editor-fold>
  public abstract /*virtual*/ void encodeInstruction(final /*const*/ MCInst /*&*/ Inst, final raw_ostream /*&*/ OS, 
                   final SmallVectorImpl<MCFixup> /*&*/ Fixups, 
                   final /*const*/ MCSubtargetInfo /*&*/ STI) /*const*//* = 0*/;

  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
