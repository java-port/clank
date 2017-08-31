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

//<editor-fold defaultstate="collapsed" desc="llvm::MCSymbolMachO">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbolMachO.h", line = 16,
 old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbolMachO.h", old_line = 15,
 FQN="llvm::MCSymbolMachO", NM="_ZN4llvm13MCSymbolMachOE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm13MCSymbolMachOE")
//</editor-fold>
public class MCSymbolMachO extends /*public*/ MCSymbol {
  /// \brief We store the value for the 'desc' symbol field in the
  /// lowest 16 bits of the implementation defined flags.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbolMachO::MachOSymbolFlags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbolMachO.h", line = 19,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbolMachO.h", old_line = 18,
   FQN="llvm::MCSymbolMachO::MachOSymbolFlags", NM="_ZN4llvm13MCSymbolMachO16MachOSymbolFlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm13MCSymbolMachO16MachOSymbolFlagsE")
  //</editor-fold>
  private static final class/*enum*/ MachOSymbolFlags/* : uint16_t*/ {
    // See <mach-o/nlist.h>.
    public static final /*uint16_t*/char SF_DescFlagsMask = $int2ushort(0xFFFF);
    
    // Reference type flags.
    public static final /*uint16_t*/char SF_ReferenceTypeMask = $int2ushort(0x0007);
    public static final /*uint16_t*/char SF_ReferenceTypeUndefinedNonLazy = $int2ushort(0x0000);
    public static final /*uint16_t*/char SF_ReferenceTypeUndefinedLazy = $int2ushort(0x0001);
    public static final /*uint16_t*/char SF_ReferenceTypeDefined = $int2ushort(0x0002);
    public static final /*uint16_t*/char SF_ReferenceTypePrivateDefined = $int2ushort(0x0003);
    public static final /*uint16_t*/char SF_ReferenceTypePrivateUndefinedNonLazy = $int2ushort(0x0004);
    public static final /*uint16_t*/char SF_ReferenceTypePrivateUndefinedLazy = $int2ushort(0x0005);
    
    // Other 'desc' flags.
    public static final /*uint16_t*/char SF_ThumbFunc = $int2ushort(0x0008);
    public static final /*uint16_t*/char SF_NoDeadStrip = $int2ushort(0x0020);
    public static final /*uint16_t*/char SF_WeakReference = $int2ushort(0x0040);
    public static final /*uint16_t*/char SF_WeakDefinition = $int2ushort(0x0080);
    public static final /*uint16_t*/char SF_SymbolResolver = $int2ushort(0x0100);
    public static final /*uint16_t*/char SF_AltEntry = $int2ushort(0x0200);
    
    // Common alignment
    public static final /*uint16_t*/char SF_CommonAlignmentMask = $int2ushort(0xF0FF);
    public static final /*uint16_t*/char SF_CommonAlignmentShift = $int2ushort(8);
  };
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbolMachO::MCSymbolMachO">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbolMachO.h", line = 45,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbolMachO.h", old_line = 43,
   FQN="llvm::MCSymbolMachO::MCSymbolMachO", NM="_ZN4llvm13MCSymbolMachOC1EPKNS_14StringMapEntryIbEEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm13MCSymbolMachOC1EPKNS_14StringMapEntryIbEEb")
  //</editor-fold>
  public MCSymbolMachO(/*const*/StringMapEntryBool/*P*/ Name, boolean isTemporary) {
    // : MCSymbol(SymbolKindMachO, Name, isTemporary) 
    super(SymbolKind.SymbolKindMachO, Name, isTemporary);
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Reference type methods.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbolMachO::clearReferenceType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbolMachO.h", line = 50,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbolMachO.h", old_line = 48,
   FQN="llvm::MCSymbolMachO::clearReferenceType", NM="_ZNK4llvm13MCSymbolMachO18clearReferenceTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm13MCSymbolMachO18clearReferenceTypeEv")
  //</editor-fold>
  public void clearReferenceType() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbolMachO::setReferenceTypeUndefinedLazy">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbolMachO.h", line = 54,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbolMachO.h", old_line = 52,
   FQN="llvm::MCSymbolMachO::setReferenceTypeUndefinedLazy", NM="_ZNK4llvm13MCSymbolMachO29setReferenceTypeUndefinedLazyEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm13MCSymbolMachO29setReferenceTypeUndefinedLazyEb")
  //</editor-fold>
  public void setReferenceTypeUndefinedLazy(boolean Value) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Other 'desc' methods.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbolMachO::setThumbFunc">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbolMachO.h", line = 61,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbolMachO.h", old_line = 59,
   FQN="llvm::MCSymbolMachO::setThumbFunc", NM="_ZNK4llvm13MCSymbolMachO12setThumbFuncEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm13MCSymbolMachO12setThumbFuncEv")
  //</editor-fold>
  public void setThumbFunc() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbolMachO::isNoDeadStrip">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbolMachO.h", line = 65,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbolMachO.h", old_line = 63,
   FQN="llvm::MCSymbolMachO::isNoDeadStrip", NM="_ZNK4llvm13MCSymbolMachO13isNoDeadStripEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm13MCSymbolMachO13isNoDeadStripEv")
  //</editor-fold>
  public boolean isNoDeadStrip() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbolMachO::setNoDeadStrip">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbolMachO.h", line = 68,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbolMachO.h", old_line = 66,
   FQN="llvm::MCSymbolMachO::setNoDeadStrip", NM="_ZNK4llvm13MCSymbolMachO14setNoDeadStripEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm13MCSymbolMachO14setNoDeadStripEv")
  //</editor-fold>
  public void setNoDeadStrip() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbolMachO::isWeakReference">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbolMachO.h", line = 72,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbolMachO.h", old_line = 70,
   FQN="llvm::MCSymbolMachO::isWeakReference", NM="_ZNK4llvm13MCSymbolMachO15isWeakReferenceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm13MCSymbolMachO15isWeakReferenceEv")
  //</editor-fold>
  public boolean isWeakReference() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbolMachO::setWeakReference">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbolMachO.h", line = 75,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbolMachO.h", old_line = 73,
   FQN="llvm::MCSymbolMachO::setWeakReference", NM="_ZNK4llvm13MCSymbolMachO16setWeakReferenceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm13MCSymbolMachO16setWeakReferenceEv")
  //</editor-fold>
  public void setWeakReference() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbolMachO::isWeakDefinition">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbolMachO.h", line = 79,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbolMachO.h", old_line = 77,
   FQN="llvm::MCSymbolMachO::isWeakDefinition", NM="_ZNK4llvm13MCSymbolMachO16isWeakDefinitionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm13MCSymbolMachO16isWeakDefinitionEv")
  //</editor-fold>
  public boolean isWeakDefinition() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbolMachO::setWeakDefinition">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbolMachO.h", line = 82,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbolMachO.h", old_line = 80,
   FQN="llvm::MCSymbolMachO::setWeakDefinition", NM="_ZNK4llvm13MCSymbolMachO17setWeakDefinitionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm13MCSymbolMachO17setWeakDefinitionEv")
  //</editor-fold>
  public void setWeakDefinition() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbolMachO::isSymbolResolver">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbolMachO.h", line = 86,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbolMachO.h", old_line = 84,
   FQN="llvm::MCSymbolMachO::isSymbolResolver", NM="_ZNK4llvm13MCSymbolMachO16isSymbolResolverEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm13MCSymbolMachO16isSymbolResolverEv")
  //</editor-fold>
  public boolean isSymbolResolver() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbolMachO::setSymbolResolver">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbolMachO.h", line = 89,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbolMachO.h", old_line = 87,
   FQN="llvm::MCSymbolMachO::setSymbolResolver", NM="_ZNK4llvm13MCSymbolMachO17setSymbolResolverEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm13MCSymbolMachO17setSymbolResolverEv")
  //</editor-fold>
  public void setSymbolResolver() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbolMachO::setAltEntry">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbolMachO.h", line = 93,
   FQN="llvm::MCSymbolMachO::setAltEntry", NM="_ZNK4llvm13MCSymbolMachO11setAltEntryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm13MCSymbolMachO11setAltEntryEv")
  //</editor-fold>
  public void setAltEntry() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbolMachO::isAltEntry">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbolMachO.h", line = 97,
   FQN="llvm::MCSymbolMachO::isAltEntry", NM="_ZNK4llvm13MCSymbolMachO10isAltEntryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm13MCSymbolMachO10isAltEntryEv")
  //</editor-fold>
  public boolean isAltEntry() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbolMachO::setDesc">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbolMachO.h", line = 101,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbolMachO.h", old_line = 91,
   FQN="llvm::MCSymbolMachO::setDesc", NM="_ZNK4llvm13MCSymbolMachO7setDescEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm13MCSymbolMachO7setDescEj")
  //</editor-fold>
  public void setDesc(/*uint*/int Value) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Get the encoded value of the flags as they will be emitted in to
  /// the MachO binary
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbolMachO::getEncodedFlags">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbolMachO.h", line = 109,
   FQN="llvm::MCSymbolMachO::getEncodedFlags", NM="_ZNK4llvm13MCSymbolMachO15getEncodedFlagsEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm13MCSymbolMachO15getEncodedFlagsEb")
  //</editor-fold>
  public /*uint16_t*/char getEncodedFlags(boolean EncodeAsAltEntry) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSymbolMachO::classof">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbolMachO.h", line = 132,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSymbolMachO.h", old_line = 119,
   FQN="llvm::MCSymbolMachO::classof", NM="_ZN4llvm13MCSymbolMachO7classofEPKNS_8MCSymbolE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm13MCSymbolMachO7classofEPKNS_8MCSymbolE")
  //</editor-fold>
  public static boolean classof(/*const*/ MCSymbol /*P*/ S) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
