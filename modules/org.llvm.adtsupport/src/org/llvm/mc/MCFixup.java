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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;


/// \brief Encode information on a single operation to perform on a byte
/// sequence (e.g., an encoded instruction) which requires assemble- or run-
/// time patching.
///
/// Fixups are used any time the target instruction encoder needs to represent
/// some value in an instruction which is not yet concrete. The encoder will
/// encode the instruction assuming the value is 0, and emit a fixup which
/// communicates to the assembler backend how it should rewrite the encoded
/// value.
///
/// During the process of relaxation, the assembler will apply fixups as
/// symbolic values become concrete. When relaxation is complete, any remaining
/// fixups become relocations in the object file (or errors, if the fixup cannot
/// be encoded on the target).
//<editor-fold defaultstate="collapsed" desc="llvm::MCFixup">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFixup.h", line = 62,
 FQN="llvm::MCFixup", NM="_ZN4llvm7MCFixupE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN4llvm7MCFixupE")
//</editor-fold>
public class MCFixup {
  /// The value to put into the fixup location. The exact interpretation of the
  /// expression is target dependent, usually it will be one of the operands to
  /// an instruction or an assembler directive.
  private /*const*/ MCExpr /*P*/ Value;
  
  /// The byte index of start of the relocation inside the encoded instruction.
  private /*uint32_t*/int Offset;
  
  /// The target dependent kind of fixup item this is. The kind is used to
  /// determine how the operand value should be encoded into the instruction.
  private /*uint*/int Kind;
  
  /// The source location which gave rise to the fixup, if any.
  private SMLoc Loc;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MCFixup::create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFixup.h", line = 78,
   FQN="llvm::MCFixup::create", NM="_ZN4llvm7MCFixup6createEjPKNS_6MCExprENS_11MCFixupKindENS_5SMLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN4llvm7MCFixup6createEjPKNS_6MCExprENS_11MCFixupKindENS_5SMLocE")
  //</editor-fold>
  public static MCFixup create(/*uint32_t*/int Offset, /*const*/ MCExpr /*P*/ Value, 
        /*MCFixupKind*//*uint*/int Kind) {
    return create(Offset, Value, 
        Kind, new SMLoc());
  }
  public static MCFixup create(/*uint32_t*/int Offset, /*const*/ MCExpr /*P*/ Value, 
        /*MCFixupKind*//*uint*/int Kind, SMLoc Loc/*= SMLoc()*/) {
    assert ($less_uint(Kind, MCFixupKind.MaxTargetFixupKind)) : "Kind out of range!";
    MCFixup FI/*J*/= new MCFixup();
    FI.Value = Value;
    FI.Offset = Offset;
    FI.Kind = ((/*uint*/int)(Kind));
    FI.Loc.$assign(Loc);
    return FI;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCFixup::getKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFixup.h", line = 89,
   FQN="llvm::MCFixup::getKind", NM="_ZNK4llvm7MCFixup7getKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZNK4llvm7MCFixup7getKindEv")
  //</editor-fold>
  public /*MCFixupKind*//*uint*/int getKind() /*const*/ {
    return ((/*MCFixupKind*//*uint*/int)(Kind));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCFixup::getOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFixup.h", line = 91,
   FQN="llvm::MCFixup::getOffset", NM="_ZNK4llvm7MCFixup9getOffsetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZNK4llvm7MCFixup9getOffsetEv")
  //</editor-fold>
  public /*uint32_t*/int getOffset() /*const*/ {
    return Offset;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCFixup::setOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFixup.h", line = 92,
   FQN="llvm::MCFixup::setOffset", NM="_ZN4llvm7MCFixup9setOffsetEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN4llvm7MCFixup9setOffsetEj")
  //</editor-fold>
  public void setOffset(/*uint32_t*/int Value) {
    Offset = Value;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCFixup::getValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFixup.h", line = 94,
   FQN="llvm::MCFixup::getValue", NM="_ZNK4llvm7MCFixup8getValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZNK4llvm7MCFixup8getValueEv")
  //</editor-fold>
  public /*const*/ MCExpr /*P*/ getValue() /*const*/ {
    return Value;
  }

  
  /// \brief Return the generic fixup kind for a value with the given size. It
  /// is an error to pass an unsupported size.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCFixup::getKindForSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFixup.h", line = 98,
   FQN="llvm::MCFixup::getKindForSize", NM="_ZN4llvm7MCFixup14getKindForSizeEjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN4llvm7MCFixup14getKindForSizeEjb")
  //</editor-fold>
  public static /*MCFixupKind*//*uint*/int getKindForSize(/*uint*/int Size, boolean isPCRel) {
    switch (Size) {
     default:
      throw new llvm_unreachable("Invalid generic fixup size!");
     case 1:
      return isPCRel ? MCFixupKind.FK_PCRel_1 : MCFixupKind.FK_Data_1;
     case 2:
      return isPCRel ? MCFixupKind.FK_PCRel_2 : MCFixupKind.FK_Data_2;
     case 4:
      return isPCRel ? MCFixupKind.FK_PCRel_4 : MCFixupKind.FK_Data_4;
     case 8:
      return isPCRel ? MCFixupKind.FK_PCRel_8 : MCFixupKind.FK_Data_8;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCFixup::getLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFixup.h", line = 108,
   FQN="llvm::MCFixup::getLoc", NM="_ZNK4llvm7MCFixup6getLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZNK4llvm7MCFixup6getLocEv")
  //</editor-fold>
  public SMLoc getLoc() /*const*/ {
    return new SMLoc(Loc);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCFixup::MCFixup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFixup.h", line = 62,
   FQN="llvm::MCFixup::MCFixup", NM="_ZN4llvm7MCFixupC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN4llvm7MCFixupC1Ev")
  //</editor-fold>
  public /*inline*/ MCFixup() {
    // : Loc() 
    //START JInit
    this.Loc = new SMLoc();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCFixup::MCFixup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFixup.h", line = 62,
   FQN="llvm::MCFixup::MCFixup", NM="_ZN4llvm7MCFixupC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN4llvm7MCFixupC1EOS0_")
  //</editor-fold>
  public /*inline*/ MCFixup(JD$Move _dparam, final MCFixup /*&&*/$Prm0) {
    // : Value(static_cast<MCFixup &&>().Value), Offset(static_cast<MCFixup &&>().Offset), Kind(static_cast<MCFixup &&>().Kind), Loc(static_cast<MCFixup &&>().Loc) 
    //START JInit
    this.Value = $Prm0.Value;
    this.Offset = $Prm0.Offset;
    this.Kind = $Prm0.Kind;
    this.Loc = new SMLoc(JD$Move.INSTANCE, $Prm0.Loc);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCFixup::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCFixup.h", line = 62,
   FQN="llvm::MCFixup::operator=", NM="_ZN4llvm7MCFixupaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN4llvm7MCFixupaSERKS0_")
  //</editor-fold>
  public /*inline*/ MCFixup /*&*/ $assign(final /*const*/ MCFixup /*&*/ $Prm0) {
    this.Value = $Prm0.Value;
    this.Offset = $Prm0.Offset;
    this.Kind = $Prm0.Kind;
    this.Loc.$assign($Prm0.Loc);
    return /*Deref*/this;
  }

  
  @Override public String toString() {
    return "" + "Value=" + "[MCExpr]" // NOI18N
              + ", Offset=" + Offset // NOI18N
              + ", Kind=" + Kind // NOI18N
              + ", Loc=" + Loc; // NOI18N
  }
}
