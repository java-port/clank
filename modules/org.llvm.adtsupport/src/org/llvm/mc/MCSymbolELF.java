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
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.aliases.*;
import static org.llvm.support.impl.AdtsupportLlvmStatics.*;

//<editor-fold defaultstate="collapsed" desc="llvm::MCSymbolELF">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbolELF.h", line = 15,
 FQN="llvm::MCSymbolELF", NM="_ZN4llvm11MCSymbolELFE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbolELF.cpp -nm=_ZN4llvm11MCSymbolELFE")
//</editor-fold>
public class MCSymbolELF extends /*public*/ MCSymbol {
  /// An expression describing how to calculate the size of a symbol. If a
  /// symbol has no size this field will be NULL.
  private /*const*/ MCExpr /*P*/ SymbolSize/* = null*/;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbolELF::MCSymbolELF">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbolELF.h", line = 21,
   FQN="llvm::MCSymbolELF::MCSymbolELF", NM="_ZN4llvm11MCSymbolELFC1EPKNS_14StringMapEntryIbEEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbolELF.cpp -nm=_ZN4llvm11MCSymbolELFC1EPKNS_14StringMapEntryIbEEb")
  //</editor-fold>
  public MCSymbolELF(/*const*/StringMapEntryBool/*P*/ Name, boolean isTemporary) {
    // : MCSymbol(SymbolKindELF, Name, isTemporary), SymbolSize(null) 
    //START JInit
    super(SymbolKind.SymbolKindELF, Name, isTemporary);
    /*InClass*/this.SymbolSize = null;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbolELF::setSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbolELF.h", line = 23,
   FQN="llvm::MCSymbolELF::setSize", NM="_ZN4llvm11MCSymbolELF7setSizeEPKNS_6MCExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbolELF.cpp -nm=_ZN4llvm11MCSymbolELF7setSizeEPKNS_6MCExprE")
  //</editor-fold>
  public void setSize(/*const*/ MCExpr /*P*/ SS) {
    SymbolSize = SS;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbolELF::getSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbolELF.h", line = 25,
   FQN="llvm::MCSymbolELF::getSize", NM="_ZNK4llvm11MCSymbolELF7getSizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbolELF.cpp -nm=_ZNK4llvm11MCSymbolELF7getSizeEv")
  //</editor-fold>
  public /*const*/ MCExpr /*P*/ getSize() /*const*/ {
    return SymbolSize;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbolELF::setVisibility">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCSymbolELF.cpp", line = 147,
   FQN="llvm::MCSymbolELF::setVisibility", NM="_ZN4llvm11MCSymbolELF13setVisibilityEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbolELF.cpp -nm=_ZN4llvm11MCSymbolELF13setVisibilityEj")
  //</editor-fold>
  public void setVisibility(/*uint*/int Visibility) {
    assert (Visibility == ELF.STV_DEFAULT || Visibility == ELF.STV_INTERNAL || Visibility == ELF.STV_HIDDEN || Visibility == ELF.STV_PROTECTED);
    
    /*uint32_t*/int OtherFlags = getFlags() & ~(0x3 << ELF_STV_Shift);
    setFlags(OtherFlags | (Visibility << ELF_STV_Shift));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbolELF::getVisibility">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCSymbolELF.cpp", line = 155,
   FQN="llvm::MCSymbolELF::getVisibility", NM="_ZNK4llvm11MCSymbolELF13getVisibilityEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbolELF.cpp -nm=_ZNK4llvm11MCSymbolELF13getVisibilityEv")
  //</editor-fold>
  public /*uint*/int getVisibility() /*const*/ {
    /*uint*/int Visibility = (getFlags() & (0x3 << ELF_STV_Shift)) >>> ELF_STV_Shift;
    assert (Visibility == ELF.STV_DEFAULT || Visibility == ELF.STV_INTERNAL || Visibility == ELF.STV_HIDDEN || Visibility == ELF.STV_PROTECTED);
    return Visibility;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbolELF::setOther">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCSymbolELF.cpp", line = 162,
   FQN="llvm::MCSymbolELF::setOther", NM="_ZN4llvm11MCSymbolELF8setOtherEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbolELF.cpp -nm=_ZN4llvm11MCSymbolELF8setOtherEj")
  //</editor-fold>
  public void setOther(/*uint*/int Other) {
    assert ((Other & 0x1F) == 0);
    Other >>>= 5;
    assert ($lesseq_uint(Other, 0x7));
    /*uint32_t*/int OtherFlags = getFlags() & ~(0x7 << ELF_STO_Shift);
    setFlags(OtherFlags | (Other << ELF_STO_Shift));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbolELF::getOther">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCSymbolELF.cpp", line = 170,
   FQN="llvm::MCSymbolELF::getOther", NM="_ZNK4llvm11MCSymbolELF8getOtherEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbolELF.cpp -nm=_ZNK4llvm11MCSymbolELF8getOtherEv")
  //</editor-fold>
  public /*uint*/int getOther() /*const*/ {
    /*uint*/int Other = (getFlags() & (0x7 << ELF_STO_Shift)) >>> ELF_STO_Shift;
    return Other << 5;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbolELF::setType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCSymbolELF.cpp", line = 94,
   FQN="llvm::MCSymbolELF::setType", NM="_ZNK4llvm11MCSymbolELF7setTypeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbolELF.cpp -nm=_ZNK4llvm11MCSymbolELF7setTypeEj")
  //</editor-fold>
  public void setType(/*uint*/int Type) /*const*/ {
    /*uint*/int Val;
    switch (Type) {
     default:
      throw new llvm_unreachable("Unsupported Binding");
     case ELF.STT_NOTYPE:
      Val = 0;
      break;
     case ELF.STT_OBJECT:
      Val = 1;
      break;
     case ELF.STT_FUNC:
      Val = 2;
      break;
     case ELF.STT_SECTION:
      Val = 3;
      break;
     case ELF.STT_COMMON:
      Val = 4;
      break;
     case ELF.STT_TLS:
      Val = 5;
      break;
     case ELF.STT_GNU_IFUNC:
      Val = 6;
      break;
    }
    /*uint32_t*/int OtherFlags = getFlags() & ~(0x7 << ELF_STT_Shift);
    setFlags(OtherFlags | (Val << ELF_STT_Shift));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbolELF::getType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCSymbolELF.cpp", line = 125,
   FQN="llvm::MCSymbolELF::getType", NM="_ZNK4llvm11MCSymbolELF7getTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbolELF.cpp -nm=_ZNK4llvm11MCSymbolELF7getTypeEv")
  //</editor-fold>
  public /*uint*/int getType() /*const*/ {
    /*uint32_t*/int Val = (getFlags() & (0x7 << ELF_STT_Shift)) >>> ELF_STT_Shift;
    switch (Val) {
     default:
      throw new llvm_unreachable("Invalid value");
     case 0:
      return ELF.STT_NOTYPE;
     case 1:
      return ELF.STT_OBJECT;
     case 2:
      return ELF.STT_FUNC;
     case 3:
      return ELF.STT_SECTION;
     case 4:
      return ELF.STT_COMMON;
     case 5:
      return ELF.STT_TLS;
     case 6:
      return ELF.STT_GNU_IFUNC;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbolELF::setBinding">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCSymbolELF.cpp", line = 43,
   FQN="llvm::MCSymbolELF::setBinding", NM="_ZNK4llvm11MCSymbolELF10setBindingEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbolELF.cpp -nm=_ZNK4llvm11MCSymbolELF10setBindingEj")
  //</editor-fold>
  public void setBinding(/*uint*/int Binding) /*const*/ {
    setIsBindingSet();
    /*uint*/int Val;
    switch (Binding) {
     default:
      throw new llvm_unreachable("Unsupported Binding");
     case ELF.STB_LOCAL:
      Val = 0;
      break;
     case ELF.STB_GLOBAL:
      Val = 1;
      break;
     case ELF.STB_WEAK:
      Val = 2;
      break;
     case ELF.STB_GNU_UNIQUE:
      Val = 3;
      break;
    }
    /*uint32_t*/int OtherFlags = getFlags() & ~(0x3 << ELF_STB_Shift);
    setFlags(OtherFlags | (Val << ELF_STB_Shift));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbolELF::getBinding">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCSymbolELF.cpp", line = 66,
   FQN="llvm::MCSymbolELF::getBinding", NM="_ZNK4llvm11MCSymbolELF10getBindingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbolELF.cpp -nm=_ZNK4llvm11MCSymbolELF10getBindingEv")
  //</editor-fold>
  public /*uint*/int getBinding() /*const*/ {
    if (isBindingSet()) {
      /*uint32_t*/int Val = (getFlags() & (0x3 << ELF_STB_Shift)) >>> ELF_STB_Shift;
      switch (Val) {
       default:
        throw new llvm_unreachable("Invalid value");
       case 0:
        return ELF.STB_LOCAL;
       case 1:
        return ELF.STB_GLOBAL;
       case 2:
        return ELF.STB_WEAK;
       case 3:
        return ELF.STB_GNU_UNIQUE;
      }
    }
    if (isDefined()) {
      return ELF.STB_LOCAL;
    }
    if (isUsedInReloc()) {
      return ELF.STB_GLOBAL;
    }
    if (isWeakrefUsedInReloc()) {
      return ELF.STB_WEAK;
    }
    if (isSignature()) {
      return ELF.STB_LOCAL;
    }
    return ELF.STB_GLOBAL;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbolELF::isBindingSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCSymbolELF.cpp", line = 198,
   FQN="llvm::MCSymbolELF::isBindingSet", NM="_ZNK4llvm11MCSymbolELF12isBindingSetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbolELF.cpp -nm=_ZNK4llvm11MCSymbolELF12isBindingSetEv")
  //</editor-fold>
  public boolean isBindingSet() /*const*/ {
    return ((getFlags() & (0x1 << ELF_BindingSet_Shift)) != 0);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbolELF::setIsWeakrefUsedInReloc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCSymbolELF.cpp", line = 175,
   FQN="llvm::MCSymbolELF::setIsWeakrefUsedInReloc", NM="_ZNK4llvm11MCSymbolELF23setIsWeakrefUsedInRelocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbolELF.cpp -nm=_ZNK4llvm11MCSymbolELF23setIsWeakrefUsedInRelocEv")
  //</editor-fold>
  public void setIsWeakrefUsedInReloc() /*const*/ {
    /*uint32_t*/int OtherFlags = getFlags() & ~(0x1 << ELF_WeakrefUsedInReloc_Shift);
    setFlags(OtherFlags | (1 << ELF_WeakrefUsedInReloc_Shift));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbolELF::isWeakrefUsedInReloc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCSymbolELF.cpp", line = 180,
   FQN="llvm::MCSymbolELF::isWeakrefUsedInReloc", NM="_ZNK4llvm11MCSymbolELF20isWeakrefUsedInRelocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbolELF.cpp -nm=_ZNK4llvm11MCSymbolELF20isWeakrefUsedInRelocEv")
  //</editor-fold>
  public boolean isWeakrefUsedInReloc() /*const*/ {
    return ((getFlags() & (0x1 << ELF_WeakrefUsedInReloc_Shift)) != 0);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbolELF::setIsSignature">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCSymbolELF.cpp", line = 184,
   FQN="llvm::MCSymbolELF::setIsSignature", NM="_ZNK4llvm11MCSymbolELF14setIsSignatureEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbolELF.cpp -nm=_ZNK4llvm11MCSymbolELF14setIsSignatureEv")
  //</editor-fold>
  public void setIsSignature() /*const*/ {
    /*uint32_t*/int OtherFlags = getFlags() & ~(0x1 << ELF_IsSignature_Shift);
    setFlags(OtherFlags | (1 << ELF_IsSignature_Shift));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbolELF::isSignature">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCSymbolELF.cpp", line = 189,
   FQN="llvm::MCSymbolELF::isSignature", NM="_ZNK4llvm11MCSymbolELF11isSignatureEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbolELF.cpp -nm=_ZNK4llvm11MCSymbolELF11isSignatureEv")
  //</editor-fold>
  public boolean isSignature() /*const*/ {
    return ((getFlags() & (0x1 << ELF_IsSignature_Shift)) != 0);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbolELF::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbolELF.h", line = 47,
   FQN="llvm::MCSymbolELF::classof", NM="_ZN4llvm11MCSymbolELF7classofEPKNS_8MCSymbolE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbolELF.cpp -nm=_ZN4llvm11MCSymbolELF7classofEPKNS_8MCSymbolE")
  //</editor-fold>
  public static boolean classof(/*const*/ MCSymbol /*P*/ S) {
    return S.isELF();
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbolELF::setIsBindingSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCSymbolELF.cpp", line = 193,
   FQN="llvm::MCSymbolELF::setIsBindingSet", NM="_ZNK4llvm11MCSymbolELF15setIsBindingSetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSymbolELF.cpp -nm=_ZNK4llvm11MCSymbolELF15setIsBindingSetEv")
  //</editor-fold>
  private void setIsBindingSet() /*const*/ {
    /*uint32_t*/int OtherFlags = getFlags() & ~(0x1 << ELF_BindingSet_Shift);
    setFlags(OtherFlags | (1 << ELF_BindingSet_Shift));
  }

  
  @Override public String toString() {
    return "" + "SymbolSize=" + "[MCExpr]" // NOI18N
              + super.toString(); // NOI18N
  }
}
