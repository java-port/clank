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
import org.llvm.adt.aliases.*;

//<editor-fold defaultstate="collapsed" desc="llvm::MCSymbolCOFF">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbolCOFF.h", line = 15,
 FQN="llvm::MCSymbolCOFF", NM="_ZN4llvm12MCSymbolCOFFE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm12MCSymbolCOFFE")
//</editor-fold>
public class MCSymbolCOFF extends /*public*/ MCSymbol {
  
  /// This corresponds to the e_type field of the COFF symbol.
  private /*mutable *//*uint16_t*/char Type;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbolCOFF::SymbolFlags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbolCOFF.h", line = 20,
   FQN="llvm::MCSymbolCOFF::SymbolFlags", NM="_ZN4llvm12MCSymbolCOFF11SymbolFlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm12MCSymbolCOFF11SymbolFlagsE")
  //</editor-fold>
  private static final class/*enum*/ SymbolFlags/* : uint16_t*/ {
    public static final /*uint16_t*/char SF_ClassMask = $int2ushort(0x00FF);
    public static final /*uint16_t*/char SF_ClassShift = $int2ushort(0);
    
    public static final /*uint16_t*/char SF_WeakExternal = $int2ushort(0x0100);
    public static final /*uint16_t*/char SF_SafeSEH = $int2ushort(0x0200);
  };
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbolCOFF::MCSymbolCOFF">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbolCOFF.h", line = 29,
   FQN="llvm::MCSymbolCOFF::MCSymbolCOFF", NM="_ZN4llvm12MCSymbolCOFFC1EPKNS_14StringMapEntryIbEEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm12MCSymbolCOFFC1EPKNS_14StringMapEntryIbEEb")
  //</editor-fold>
  public MCSymbolCOFF(/*const*/StringMapEntryBool/*P*/ Name, boolean isTemporary) {
    // : MCSymbol(SymbolKindCOFF, Name, isTemporary), Type(0) 
    //START JInit
    super(SymbolKind.SymbolKindCOFF, Name, isTemporary);
    this.Type = $int2ushort(0);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbolCOFF::getType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbolCOFF.h", line = 32,
   FQN="llvm::MCSymbolCOFF::getType", NM="_ZNK4llvm12MCSymbolCOFF7getTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm12MCSymbolCOFF7getTypeEv")
  //</editor-fold>
  public /*uint16_t*/char getType() /*const*/ {
    return Type;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbolCOFF::setType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbolCOFF.h", line = 35,
   FQN="llvm::MCSymbolCOFF::setType", NM="_ZNK4llvm12MCSymbolCOFF7setTypeEt",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm12MCSymbolCOFF7setTypeEt")
  //</editor-fold>
  public void setType(/*uint16_t*/char Ty) /*const*/ {
    Type = Ty;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbolCOFF::getClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbolCOFF.h", line = 39,
   FQN="llvm::MCSymbolCOFF::getClass", NM="_ZNK4llvm12MCSymbolCOFF8getClassEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm12MCSymbolCOFF8getClassEv")
  //</editor-fold>
  public /*uint16_t*/char __getClass() /*const*/ {
    return $uint2ushort((getFlags() & $ushort2uint(SymbolFlags.SF_ClassMask)) >>> $ushort2int(SymbolFlags.SF_ClassShift));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbolCOFF::setClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbolCOFF.h", line = 42,
   FQN="llvm::MCSymbolCOFF::setClass", NM="_ZNK4llvm12MCSymbolCOFF8setClassEt",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm12MCSymbolCOFF8setClassEt")
  //</editor-fold>
  public void setClass(/*uint16_t*/char StorageClass) /*const*/ {
    modifyFlags($ushort2int(StorageClass) << $ushort2int(SymbolFlags.SF_ClassShift), $ushort2uint(SymbolFlags.SF_ClassMask));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbolCOFF::isWeakExternal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbolCOFF.h", line = 46,
   FQN="llvm::MCSymbolCOFF::isWeakExternal", NM="_ZNK4llvm12MCSymbolCOFF14isWeakExternalEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm12MCSymbolCOFF14isWeakExternalEv")
  //</editor-fold>
  public boolean isWeakExternal() /*const*/ {
    return ((getFlags() & $ushort2uint(SymbolFlags.SF_WeakExternal)) != 0);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbolCOFF::setIsWeakExternal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbolCOFF.h", line = 49,
   FQN="llvm::MCSymbolCOFF::setIsWeakExternal", NM="_ZNK4llvm12MCSymbolCOFF17setIsWeakExternalEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm12MCSymbolCOFF17setIsWeakExternalEv")
  //</editor-fold>
  public void setIsWeakExternal() /*const*/ {
    modifyFlags($ushort2uint(SymbolFlags.SF_WeakExternal), $ushort2uint(SymbolFlags.SF_WeakExternal));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbolCOFF::isSafeSEH">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbolCOFF.h", line = 53,
   FQN="llvm::MCSymbolCOFF::isSafeSEH", NM="_ZNK4llvm12MCSymbolCOFF9isSafeSEHEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm12MCSymbolCOFF9isSafeSEHEv")
  //</editor-fold>
  public boolean isSafeSEH() /*const*/ {
    return ((getFlags() & $ushort2uint(SymbolFlags.SF_SafeSEH)) != 0);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbolCOFF::setIsSafeSEH">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbolCOFF.h", line = 56,
   FQN="llvm::MCSymbolCOFF::setIsSafeSEH", NM="_ZNK4llvm12MCSymbolCOFF12setIsSafeSEHEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm12MCSymbolCOFF12setIsSafeSEHEv")
  //</editor-fold>
  public void setIsSafeSEH() /*const*/ {
    modifyFlags($ushort2uint(SymbolFlags.SF_SafeSEH), $ushort2uint(SymbolFlags.SF_SafeSEH));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbolCOFF::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbolCOFF.h", line = 60,
   FQN="llvm::MCSymbolCOFF::classof", NM="_ZN4llvm12MCSymbolCOFF7classofEPKNS_8MCSymbolE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm12MCSymbolCOFF7classofEPKNS_8MCSymbolE")
  //</editor-fold>
  public static boolean classof(/*const*/ MCSymbol /*P*/ S) {
    return S.isCOFF();
  }

  
  @Override public String toString() {
    return "" + "Type=" + $ushort2uint(Type) // NOI18N
              + super.toString(); // NOI18N
  }
}
