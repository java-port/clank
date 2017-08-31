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

package org.clang.serialization.reader.impl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.serialization.*;
import static org.clang.serialization.impl.ASTReaderStatics.*;
import org.llvm.support.llvm.support.endian;
import org.llvm.support.llvm.support.endianness;


/// \brief Class that performs lookup for an identifier stored in an AST file.
//<editor-fold defaultstate="collapsed" desc="clang::serialization::reader::ASTIdentifierLookupTrait">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderInternals.h", line = 165,
 FQN="clang::serialization::reader::ASTIdentifierLookupTrait", NM="_ZN5clang13serialization6reader24ASTIdentifierLookupTraitE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13serialization6reader24ASTIdentifierLookupTraitE")
//</editor-fold>
public class ASTIdentifierLookupTrait extends /*public*/ ASTIdentifierLookupTraitBase<IdentifierInfo> {
  private final ASTReader /*&*/ Reader;
  private final ModuleFile /*&*/ F;
  
  // If we know the IdentifierInfo in advance, it is here and we will
  // not build a new one. Used when deserializing information about an
  // identifier that was constructed before the AST file was read.
  private IdentifierInfo /*P*/ KnownII;
/*public:*/
  // JAVA: typedef IdentifierInfo *data_type
//  public final class data_type extends IdentifierInfo /*P*/ { };
  
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::reader::ASTIdentifierLookupTrait::ASTIdentifierLookupTrait">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderInternals.h", line = 177,
   FQN="clang::serialization::reader::ASTIdentifierLookupTrait::ASTIdentifierLookupTrait", NM="_ZN5clang13serialization6reader24ASTIdentifierLookupTraitC1ERNS_9ASTReaderERNS0_10ModuleFileEPNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13serialization6reader24ASTIdentifierLookupTraitC1ERNS_9ASTReaderERNS0_10ModuleFileEPNS_14IdentifierInfoE")
  //</editor-fold>
  public ASTIdentifierLookupTrait(final ASTReader /*&*/ Reader, final ModuleFile /*&*/ F) {
    this(Reader, F, 
      (IdentifierInfo /*P*/ )null);
  }
  public ASTIdentifierLookupTrait(final ASTReader /*&*/ Reader, final ModuleFile /*&*/ F, 
      IdentifierInfo /*P*/ II/*= null*/) {
    // : ASTIdentifierLookupTraitBase(), Reader(Reader), F(F), KnownII(II) 
    //START JInit
    super();
    this./*&*/Reader=/*&*/Reader;
    this./*&*/F=/*&*/F;
    this.KnownII = II;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::reader::ASTIdentifierLookupTrait::ReadData">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 786,
   FQN="clang::serialization::reader::ASTIdentifierLookupTrait::ReadData", NM="_ZN5clang13serialization6reader24ASTIdentifierLookupTrait8ReadDataERKN4llvm9StringRefEPKhj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13serialization6reader24ASTIdentifierLookupTrait8ReadDataERKN4llvm9StringRefEPKhj")
  //</editor-fold>
  @Override public final IdentifierInfo /*P*/ ReadData(final /*const*/ StringRef /*&*/ k, 
          /*const*/char$ptr/*uchar P*/ Buf, int OffsetInfBuf, 
          /*uint*/int DataLen) {
    //JAVA: using namespace llvm::support;
    /*uint*/int RawID = endian.read_uint32(endianness.little, llvm.support.unaligned, Buf, OffsetInfBuf);
                        OffsetInfBuf += NativeType.sizeof$uint32();
    boolean IsInteresting = ((RawID & 0x01) != 0);
    
    // Wipe out the "is interesting" bit.
    RawID = RawID >>> 1;
    
    // Build the IdentifierInfo and link the identifier ID with it.
    IdentifierInfo /*P*/ II = KnownII;
    if (!(II != null)) {
      II = $AddrOf(Reader.getIdentifierTable().getOwn(/*NO_COPY*/k));
      KnownII = II;
    }
    markIdentifierFromAST(Reader, $Deref(II));
    Reader.markIdentifierUpToDate(II);
    
    /*uint32_t*/int ID = Reader.getGlobalIdentifierID(F, RawID);
    if (!IsInteresting) {
      // For uninteresting identifiers, there's nothing else to do. Just notify
      // the reader that we've finished loading this identifier.
      Reader.SetIdentifierInfo(ID, II);
      return II;
    }
    
    /*uint*/int ObjCOrBuiltinID = $ushort2uint(endian.read_uint16(endianness.little, 1, Buf, OffsetInfBuf));
                                  OffsetInfBuf += NativeType.sizeof$uint16();
    uint$ref Bits = create_uint$ref($ushort2uint(endian.read_uint16(endianness.little, 1, Buf, OffsetInfBuf)));
                                  OffsetInfBuf += NativeType.sizeof$uint16();
    boolean CPlusPlusOperatorKeyword = readBit(Bits);
    boolean HasRevertedTokenIDToIdentifier = readBit(Bits);
    boolean HasRevertedBuiltin = readBit(Bits);
    boolean Poisoned = readBit(Bits);
    boolean ExtensionToken = readBit(Bits);
    boolean HadMacroDefinition = readBit(Bits);
    assert (Bits.$deref() == 0) : "Extra bits in the identifier?";
    DataLen -= 8;
    
    // Set or check the various bits in the IdentifierInfo structure.
    // Token IDs are read-only.
    if (HasRevertedTokenIDToIdentifier && II.getTokenID() != tok.TokenKind.identifier) {
      II.revertTokenIDToIdentifier();
    }
    if (!F.isModule()) {
      II.setObjCOrBuiltinID(ObjCOrBuiltinID);
    } else if (HasRevertedBuiltin && (II.getBuiltinID() != 0)) {
      II.revertBuiltin();
      assert ((II.hasRevertedBuiltin() || II.getObjCOrBuiltinID() == ObjCOrBuiltinID)) : "Incorrect ObjC keyword or builtin ID";
    }
    assert (II.isExtensionToken() == ExtensionToken) : "Incorrect extension token flag";
    ///*J:(void)*/ExtensionToken;
    if (Poisoned) {
      II.setIsPoisoned(true);
    }
    assert (II.isCPlusPlusOperatorKeyword() == CPlusPlusOperatorKeyword) : "Incorrect C++ operator keyword flag";
    ///*J:(void)*/CPlusPlusOperatorKeyword;
    
    // If this identifier is a macro, deserialize the macro
    // definition.
    if (HadMacroDefinition) {
      /*uint32_t*/int MacroDirectivesOffset = endian.read_uint32(endianness.little, llvm.support.unaligned, Buf, OffsetInfBuf);
                                              OffsetInfBuf += NativeType.sizeof$uint32();
      DataLen -= 4;
      
      Reader.addPendingMacro(II, $AddrOf(F), $uint2ulong(MacroDirectivesOffset));
    }
    
    Reader.SetIdentifierInfo(ID, II);
    
    // Read all of the declarations visible at global scope with this
    // name.
    if ($greater_uint(DataLen, 0)) {
      SmallVectorUInt DeclIDs/*J*/= new SmallVectorUInt(4, (/*uint32_t*/int)0);
      for (; $greater_uint(DataLen, 0); DataLen -= 4)  {
        DeclIDs.push_back(Reader.getGlobalDeclID(F, endian.read_uint32(endianness.little, llvm.support.unaligned, Buf, OffsetInfBuf)));
                                                    OffsetInfBuf += NativeType.sizeof$uint32();
      }
      Reader.SetGloballyVisibleDecls(II, DeclIDs);
    }
    
    return II;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::reader::ASTIdentifierLookupTrait::ReadIdentifierID">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 771,
   FQN="clang::serialization::reader::ASTIdentifierLookupTrait::ReadIdentifierID", NM="_ZN5clang13serialization6reader24ASTIdentifierLookupTrait16ReadIdentifierIDEPKh",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13serialization6reader24ASTIdentifierLookupTrait16ReadIdentifierIDEPKh")
  //</editor-fold>
  public /*uint32_t*/int ReadIdentifierID(/*const*/char$ptr/*uchar P*/ Buf, int OffsetInfBuf) {
    // JAVA: passed Buf is not changed in the call, so just read
    //JAVA: using namespace llvm::support;
    /*uint*/int RawID = endian.read_uint32(endianness.little, llvm.support.unaligned, Buf, OffsetInfBuf);
    return Reader.getGlobalIdentifierID(F, RawID >>> 1);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::reader::ASTIdentifierLookupTrait::getReader">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderInternals.h", line = 187,
   FQN="clang::serialization::reader::ASTIdentifierLookupTrait::getReader", NM="_ZNK5clang13serialization6reader24ASTIdentifierLookupTrait9getReaderEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang13serialization6reader24ASTIdentifierLookupTrait9getReaderEv")
  //</editor-fold>
  public ASTReader /*&*/ getReader() /*const*/ {
    return Reader;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::serialization::reader::ASTIdentifierLookupTrait::ASTIdentifierLookupTrait">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderInternals.h", line = 165,
   FQN="clang::serialization::reader::ASTIdentifierLookupTrait::ASTIdentifierLookupTrait", NM="_ZN5clang13serialization6reader24ASTIdentifierLookupTraitC1ERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13serialization6reader24ASTIdentifierLookupTraitC1ERKS2_")
  //</editor-fold>
  public /*inline*/ ASTIdentifierLookupTrait(final /*const*/ ASTIdentifierLookupTrait /*&*/ $Prm0) {
    // : ASTIdentifierLookupTraitBase(), Reader(.Reader), F(.F), KnownII(.KnownII) 
    //START JInit
    super($Prm0);
    this./*&*/Reader=/*&*/$Prm0.Reader;
    this./*&*/F=/*&*/$Prm0.F;
    this.KnownII = $Prm0.KnownII;
    //END JInit
  }
  
  @Override public String toString() {
    return "" + "Reader=[" + Reader // NOI18N
              + "], F=[" + F // NOI18N
              + "], KnownII=[" + KnownII // NOI18N
              + "]" + super.toString(); // NOI18N
  }
}
