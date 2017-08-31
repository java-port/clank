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

package org.clang.serialization.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Unsigned.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.sema.*;
import org.clang.serialization.*;
import static org.clang.serialization.impl.ASTWriterStatics.getDeclForLocalLookup;
import static org.clank.java.std_pair.wrap_uint_uint_pair;
import static org.llvm.adt.ADTAliases.$noteq_reverse_iterator$C;
import org.llvm.adt.aliases.*;
import org.llvm.support.*;
import org.llvm.support.endian.Writer;
import static org.llvm.support.llvm.support.endianness.little;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTIdentifierTableTrait">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 3138,
 FQN="(anonymous namespace)::ASTIdentifierTableTrait", NM="_ZN12_GLOBAL__N_123ASTIdentifierTableTraitE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_123ASTIdentifierTableTraitE")
//</editor-fold>
public class ASTIdentifierTableTrait implements OnDiskChainedHashTableGenerator.EmitInfoInterface<IdentifierInfo, Integer, Void/*unused*/> {
  private final ASTWriter /*&*/ Writer;
  private final Preprocessor /*&*/ PP;
  private final IdentifierResolver /*&*/ IdResolver;
  private boolean IsModule;
  private boolean NeedDecls;
  private SmallVectorULong /*P*/ InterestingIdentifierOffsets;
  
  /// \brief Determines whether this is an "interesting" identifier that needs a
  /// full IdentifierInfo structure written into the hash table. Notably, this
  /// doesn't check whether the name has macros defined; use PublicMacroIterator
  /// to check that.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTIdentifierTableTrait::isInterestingIdentifier">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 3150,
   FQN="(anonymous namespace)::ASTIdentifierTableTrait::isInterestingIdentifier", NM="_ZN12_GLOBAL__N_123ASTIdentifierTableTrait23isInterestingIdentifierEPKN5clang14IdentifierInfoEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_123ASTIdentifierTableTrait23isInterestingIdentifierEPKN5clang14IdentifierInfoEy")
  //</editor-fold>
  private boolean isInterestingIdentifier(/*const*/ IdentifierInfo /*P*/ II, long/*uint64_t*/ MacroOffset) {
    if ((MacroOffset != 0)
       || II.isPoisoned()
       || ((IsModule ? (II.hasRevertedBuiltin() ? 1 : 0) : II.getObjCOrBuiltinID()) != 0)
       || II.hasRevertedTokenIDToIdentifier()
       || (NeedDecls && (II./*<void>*/getFETokenInfo() != null))) {
      return true;
    }
    
    return false;
  }

/*public:*/
  // JAVA: typedef IdentifierInfo *key_type
//  public final class key_type extends IdentifierInfo /*P*/ { };
  // JAVA: typedef key_type key_type_ref
//  public final class key_type_ref extends IdentifierInfo /*P*/ { };
  
  // JAVA: typedef IdentID data_type;
  // JAVA: typedef data_type data_type_ref;
  
  // JAVA: typedef unsigned int hash_value_type;
  // JAVA: typedef unsigned int offset_type;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTIdentifierTableTrait::ASTIdentifierTableTrait">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 3171,
   FQN="(anonymous namespace)::ASTIdentifierTableTrait::ASTIdentifierTableTrait", NM="_ZN12_GLOBAL__N_123ASTIdentifierTableTraitC1ERN5clang9ASTWriterERNS1_12PreprocessorERNS1_18IdentifierResolverEbPN4llvm11SmallVectorIyLj64EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_123ASTIdentifierTableTraitC1ERN5clang9ASTWriterERNS1_12PreprocessorERNS1_18IdentifierResolverEbPN4llvm11SmallVectorIyLj64EEE")
  //</editor-fold>
  public ASTIdentifierTableTrait(final ASTWriter /*&*/ Writer, final Preprocessor /*&*/ PP, 
      final IdentifierResolver /*&*/ IdResolver, boolean IsModule, 
      SmallVectorULong /*P*/ InterestingIdentifierOffsets) {
    // : Writer(Writer), PP(PP), IdResolver(IdResolver), IsModule(IsModule), NeedDecls(!IsModule || !Writer.getLangOpts().CPlusPlus), InterestingIdentifierOffsets(InterestingIdentifierOffsets) 
    //START JInit
    this./*&*/Writer=/*&*/Writer;
    this./*&*/PP=/*&*/PP;
    this./*&*/IdResolver=/*&*/IdResolver;
    this.IsModule = IsModule;
    this.NeedDecls = !IsModule || !Writer.getLangOpts().CPlusPlus;
    this.InterestingIdentifierOffsets = InterestingIdentifierOffsets;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTIdentifierTableTrait::needDecls">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 3178,
   FQN="(anonymous namespace)::ASTIdentifierTableTrait::needDecls", NM="_ZNK12_GLOBAL__N_123ASTIdentifierTableTrait9needDeclsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZNK12_GLOBAL__N_123ASTIdentifierTableTrait9needDeclsEv")
  //</editor-fold>
  public boolean needDecls() /*const*/ {
    return NeedDecls;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTIdentifierTableTrait::ComputeHash">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 3180,
   FQN="(anonymous namespace)::ASTIdentifierTableTrait::ComputeHash", NM="_ZN12_GLOBAL__N_123ASTIdentifierTableTrait11ComputeHashEPKN5clang14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_123ASTIdentifierTableTrait11ComputeHashEPKN5clang14IdentifierInfoE")
  //</editor-fold>
  @Override public final /*uint*/int ComputeHash(/*const*/ IdentifierInfo /*P*/ II) {
    return llvm.HashString(II.getName());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTIdentifierTableTrait::isInterestingIdentifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 3184,
   FQN="(anonymous namespace)::ASTIdentifierTableTrait::isInterestingIdentifier", NM="_ZN12_GLOBAL__N_123ASTIdentifierTableTrait23isInterestingIdentifierEPKN5clang14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_123ASTIdentifierTableTrait23isInterestingIdentifierEPKN5clang14IdentifierInfoE")
  //</editor-fold>
  public boolean isInterestingIdentifier(/*const*/ IdentifierInfo /*P*/ II) {
    long/*uint64_t*/ MacroOffset = Writer.getMacroDirectivesOffset(II);
    return isInterestingIdentifier(II, MacroOffset);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTIdentifierTableTrait::isInterestingNonMacroIdentifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 3188,
   FQN="(anonymous namespace)::ASTIdentifierTableTrait::isInterestingNonMacroIdentifier", NM="_ZN12_GLOBAL__N_123ASTIdentifierTableTrait31isInterestingNonMacroIdentifierEPKN5clang14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_123ASTIdentifierTableTrait31isInterestingNonMacroIdentifierEPKN5clang14IdentifierInfoE")
  //</editor-fold>
  public boolean isInterestingNonMacroIdentifier(/*const*/ IdentifierInfo /*P*/ II) {
    return isInterestingIdentifier(II, $int2ulong(0));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTIdentifierTableTrait::EmitKeyDataLength">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 3192,
   FQN="(anonymous namespace)::ASTIdentifierTableTrait::EmitKeyDataLength", NM="_ZN12_GLOBAL__N_123ASTIdentifierTableTrait17EmitKeyDataLengthERN4llvm11raw_ostreamEPN5clang14IdentifierInfoEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_123ASTIdentifierTableTrait17EmitKeyDataLengthERN4llvm11raw_ostreamEPN5clang14IdentifierInfoEj")
  //</editor-fold>
  @Override public final std.pairUIntUInt EmitKeyDataLength(final raw_ostream /*&*/ Out, IdentifierInfo /*P*/ II, /*uint32_t*/Integer ID) {
    throw new UnsupportedOperationException("EmitKeyDataLength$WrapPair must be used");
  }
  @Override public final /*std.pair<uint, uint>*/long EmitKeyDataLength$WrapPair(final raw_ostream /*&*/ Out, IdentifierInfo /*P*/ II, /*uint32_t*/Integer ID) {
    /*uint*/int KeyLen = II.getLength() + 1;
    /*uint*/int DataLen = 4; // 4 bytes for the persistent ID << 1
    long/*uint64_t*/ MacroOffset = Writer.getMacroDirectivesOffset(II);
    if (isInterestingIdentifier(II, MacroOffset)) {
      DataLen += 2; // 2 bytes for builtin ID
      DataLen += 2; // 2 bytes for flags
      if ((MacroOffset != 0)) {
        DataLen += 4; // MacroDirectives offset.
      }
      if (NeedDecls) {
        for (IdentifierResolver.iterator D = IdResolver.begin(new DeclarationName(II)), 
            DEnd = IdResolver.end();
             D.$noteq(DEnd); D.$preInc())  {
          DataLen += 4;
        }
      }
    }
    //JAVA: using namespace llvm::support;
    Writer LE/*J*/= new Writer(little, Out);
    assert (DataLen == DataLen && KeyLen == KeyLen);
    LE.write_uint16($uint2ushort(DataLen));
    // We emit the key length after the data length so that every
    // string is preceded by a 16-bit length. This matches the PTH
    // format for storing identifiers.
    LE.write_uint16($uint2ushort(KeyLen));
    return wrap_uint_uint_pair(KeyLen, DataLen);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTIdentifierTableTrait::EmitKey">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 3222,
   FQN="(anonymous namespace)::ASTIdentifierTableTrait::EmitKey", NM="_ZN12_GLOBAL__N_123ASTIdentifierTableTrait7EmitKeyERN4llvm11raw_ostreamEPKN5clang14IdentifierInfoEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_123ASTIdentifierTableTrait7EmitKeyERN4llvm11raw_ostreamEPKN5clang14IdentifierInfoEj")
  //</editor-fold>
  @Override public final void EmitKey(final raw_ostream /*&*/ Out, /*const*/ IdentifierInfo /*P*/ II, 
         /*uint*/int KeyLen) {
    // Record the location of the key data.  This is used when generating
    // the mapping from persistent IDs to strings.
    Writer.SetIdentifierOffset(II, $ulong2uint(Out.tell()));
    
    // Emit the offset of the key/data length information to the interesting
    // identifiers table if necessary.
    if ((InterestingIdentifierOffsets != null) && isInterestingIdentifier(II)) {
      InterestingIdentifierOffsets.push_back(Out.tell() - $int2ullong(4));
    }
    
    Out.write(II.getNameStart(), KeyLen);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTIdentifierTableTrait::EmitData">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 3236,
   FQN="(anonymous namespace)::ASTIdentifierTableTrait::EmitData", NM="_ZN12_GLOBAL__N_123ASTIdentifierTableTrait8EmitDataERN4llvm11raw_ostreamEPN5clang14IdentifierInfoEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_123ASTIdentifierTableTrait8EmitDataERN4llvm11raw_ostreamEPN5clang14IdentifierInfoEjj")
  //</editor-fold>
  @Override public final void EmitData(final raw_ostream /*&*/ Out, IdentifierInfo /*P*/ II, 
          /*uint32_t*/Integer ID, /*uint*/int $Prm3) {
    //JAVA: using namespace llvm::support;
    Writer LE/*J*/= new Writer(little, Out);
    
    long/*uint64_t*/ MacroOffset = Writer.getMacroDirectivesOffset(II);
    if (!isInterestingIdentifier(II, MacroOffset)) {
      LE.write_uint32(ID << 1);
      return;
    }
    
    LE.write_uint32((ID << 1) | 0x01);
    /*uint32_t*/int Bits = (/*uint32_t*/int)II.getObjCOrBuiltinID();
    assert ((Bits & 0xFFFF) == Bits) : "ObjCOrBuiltinID too big for ASTReader.";
    LE.write_uint16($uint2ushort(Bits));
    Bits = 0;
    boolean HadMacroDefinition = MacroOffset != $int2ullong(0);
    Bits = (Bits << 1) | ((/*uint*/int)((HadMacroDefinition ? 1 : 0)));
    Bits = (Bits << 1) | ((/*uint*/int)((II.isExtensionToken() ? 1 : 0)));
    Bits = (Bits << 1) | ((/*uint*/int)((II.isPoisoned() ? 1 : 0)));
    Bits = (Bits << 1) | ((/*uint*/int)((II.hasRevertedBuiltin() ? 1 : 0)));
    Bits = (Bits << 1) | ((/*uint*/int)((II.hasRevertedTokenIDToIdentifier() ? 1 : 0)));
    Bits = (Bits << 1) | ((/*uint*/int)((II.isCPlusPlusOperatorKeyword() ? 1 : 0)));
    LE.write_uint16($uint2ushort(Bits));
    if (HadMacroDefinition) {
      LE.write_uint32($ullong2uint(MacroOffset));
    }
    if (NeedDecls) {
      // Emit the declaration IDs in reverse order, because the
      // IdentifierResolver provides the declarations as they would be
      // visible (e.g., the function "stat" would come before the struct
      // "stat"), but the ASTReader adds declarations to the end of the list
      // (so we need to see the struct "stat" before the function "stat").
      // Only emit declarations that aren't from a chained PCH, though.
      SmallVector<NamedDecl /*P*/ > Decls/*J*/= new SmallVector<NamedDecl /*P*/ >(JD$T.INSTANCE, 16, (type$iterator)IdResolver.begin(new DeclarationName(II)), 
          (type$iterator)IdResolver.end(), (NamedDecl /*P*/ )null);
      for (std.reverse_iterator<NamedDecl /*P*/ > D = Decls.rbegin(), 
          DEnd = Decls.rend();
           $noteq_reverse_iterator$C(D, DEnd); D.$preInc())  {
        LE.write_uint32(Writer.getDeclID(getDeclForLocalLookup(PP.getLangOpts(), D.$star())));
      }
    }
  }
  
  @Override public String toString() {
    return "" + "Writer=" + Writer // NOI18N
              + ", PP=" + "[Preprocessor]" // NOI18N
              + ", IdResolver=" + IdResolver // NOI18N
              + ", IsModule=" + IsModule // NOI18N
              + ", NeedDecls=" + NeedDecls // NOI18N
              + ", InterestingIdentifierOffsets=" + InterestingIdentifierOffsets; // NOI18N
  }
}
