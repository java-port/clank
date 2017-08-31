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

package org.clang.basic;

import java.util.Comparator;
import org.clang.basic.llvm.DenseMapInfoIdentifierInfo$Ptr;
import static org.clang.basic.impl.IdentifierTableStatics.getTokenKwStatus;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.clang.basic.*;

// JAVA: this class was very intensively optimized for Java
// It extends own Entry which is placed into DenseMaps

/// One of these records is kept for each identifier that
/// is lexed.  This contains information about whether the token was \#define'd,
/// is a language keyword, or if it is a front-end token of some sort (e.g. a
/// variable or function name).  The preprocessor keeps this information in a
/// set, and all tok::identifier tokens have a pointer to one of these.
//<editor-fold defaultstate="collapsed" desc="clang::IdentifierInfo">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC, 
 optimized = Converted.Optimization.COMPLEX,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 47,
 FQN = "clang::IdentifierInfo", NM = "_ZN5clang14IdentifierInfoE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZN5clang14IdentifierInfoE")
//</editor-fold>
public final class IdentifierInfo extends IdentifierInfoStringMapEntry implements Native.ComparableLower {
  public static final DenseMapInfo<IdentifierInfo> DMI$IdentifierInfoPtr = new DenseMapInfoIdentifierInfo$Ptr();

//  public static final DenseMapInfo<IdentifierInfo> DenseMapInfo = new DenseMapInfoIdentifierInfo();
  /*friend*/static final IdentifierInfo SET_VALUE_PLACEHOLDER = new IdentifierInfo();
  /*friend*/public IdentifierInfo() {
    this(NativePointer.$EMPTY, 0);
  }
  private long Union_Flags; // field where all properties are kept as in 64-bit field
//  /*package*//*tok.TokenKind*/char TokenID /*: 9*/; // Front-end token ID or tok::identifier.
  private static final int TokenID = 9;
  private static final long TokenID_Mask = 0b111111111L;
  private static final long TokenID_Clear = ~TokenID_Mask;
  // Objective-C keyword ('protocol' in '@protocol') or builtin (__builtin_inf).
  // First NUM_OBJC_KEYWORDS values are for Objective-C, the remaining values
  // are for builtins.
//  private /*JCHAR unsigned int*/ char ObjCOrBuiltinID /*: 13*/;
  private static final int ObjCOrBuiltinIDBits = 13;
  private static final int ObjCOrBuiltinID = TokenID + ObjCOrBuiltinIDBits;
  private static final long ObjCOrBuiltinID_Mask = 0b1111111111111000000000L;
//  private /*JBIT bool*/ boolean HasMacro /*: 1*/; // True if there is a #define for this.
  private static final long HasMacro = 1L << ObjCOrBuiltinID;
  static {
    assert (TokenID_Mask & ObjCOrBuiltinID_Mask) == 0L;
    assert (HasMacro-1L) == (ObjCOrBuiltinID_Mask | TokenID_Mask) : 
            "\n" + Long.toBinaryString(HasMacro - 1L) + "\nvs\n" + 
            Long.toBinaryString((ObjCOrBuiltinID_Mask | TokenID_Mask));
  }
//  private /*JBIT bool*/ boolean HadMacro /*: 1*/; // True if there was a #define for this.
  private static final long HadMacro = HasMacro << 1;
//  private /*JBIT bool*/ boolean IsExtension /*: 1*/; // True if identifier is a lang extension.
  private static final long IsExtension = HadMacro << 1;
//  private /*JBIT bool*/ boolean IsFutureCompatKeyword /*: 1*/ // True if identifier is a keyword in a
                                                              // newer Standard or proposed Standard.
  private static final long IsFutureCompatKeyword = IsExtension << 1;
//  private /*JBIT bool*/ boolean IsPoisoned /*: 1*/; // True if identifier is poisoned.
  private static final long IsPoisoned = IsFutureCompatKeyword << 1;
//  private /*JBIT bool*/ boolean IsCPPOperatorKeyword /*: 1*/; // True if ident is a C++ operator keyword.
  private static final long IsCPPOperatorKeyword = IsPoisoned << 1;
//  private /*JBIT bool*/ boolean NeedsHandleIdentifier /*: 1*/; // See "RecomputeNeedsHandleIdentifier".
  private static final long NeedsHandleIdentifier = IsCPPOperatorKeyword << 1;
//  private /*JBIT bool*/ boolean IsFromAST /*: 1*/; // True if identifier was loaded (at least 
                                                     // partially) from an AST file.
  private static final long IsFromAST = NeedsHandleIdentifier << 1;
//  private /*JBIT bool*/ boolean ChangedAfterLoad /*: 1*/; // True if identifier has changed from the
                                                            // definition loaded from an AST file.
  private static final long ChangedAfterLoad = IsFromAST << 1;
  //private /*JBIT bool*/ boolean FEChangedAfterLoad /*: 1*/; // True if identifier's frontend information
                                                            // has changed from the definition loaded
                                                            // from an AST file.  
  private static final long FEChangedAfterLoad = ChangedAfterLoad << 1;
//  private /*JBIT bool*/ boolean RevertedTokenID /*: 1*/; // True if revertTokenIDToIdentifier was
  private static final long RevertedTokenID = FEChangedAfterLoad << 1;
  // called.
//  private /*JBIT bool*/ boolean OutOfDate /*: 1*/; // True if there may be additional
  private static final long OutOfDate = RevertedTokenID << 1;
  // information about this identifier
  // stored externally.
//  private /*JBIT bool*/ boolean IsModulesImport /*: 1*/; // True if this is the 'import' contextual keyword
  private static final long IsModulesImport = OutOfDate << 1;
  // 29 bit left in 64-bit word.
  static {
    // 29 bit left in 64-bit word.
    assert IsModulesImport == 0x400000000L : "bigger than long" + Long.toHexString(IsModulesImport);
  }

  private Object/*void P*/ FETokenInfo; // Managed by the language front-end.
//  /*package*/StringMapEntryIdentifierInfo /*P*/ Entry;
  // special marker kept in FETokenInfo field to specify we don't have yet Value in Entry
  private static final Object NO_ENTRY_AND_VALUE = NativePointer.create_type$null$ptr();
  //<editor-fold defaultstate="collapsed" desc="clang::IdentifierInfo::IdentifierInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 80,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 77,
   FQN="clang::IdentifierInfo::IdentifierInfo", NM="_ZN5clang14IdentifierInfoC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZN5clang14IdentifierInfoC1ERKS0_")
  //</editor-fold>
  private IdentifierInfo(/*const*/IdentifierInfo /*&*/ $Prm0) {
    super($Prm0);
    throw new UnsupportedOperationException("LLVM_DELETED_FUNCTION");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::IdentifierInfo::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 81,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 78,
   FQN="clang::IdentifierInfo::operator=", NM="_ZN5clang14IdentifierInfoaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZN5clang14IdentifierInfoaSERKS0_")
  //</editor-fold>
  private void $assign(/*const*/IdentifierInfo /*&*/ $Prm0) {throw new UnsupportedOperationException("LLVM_DELETED_FUNCTION");}

  /*friend  class IdentifierTable*/;
/*public:*/
  
  //===----------------------------------------------------------------------===//
  // IdentifierInfo Implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::IdentifierInfo::IdentifierInfo">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", line = 33,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", old_line = 32,
   FQN = "clang::IdentifierInfo::IdentifierInfo", NM = "_ZN5clang14IdentifierInfoC1Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZN5clang14IdentifierInfoC1Ev")
  //</editor-fold>
  public IdentifierInfo(char$ptr Str, int Len) {
    super(Str, Len);
    Union_Flags = tok.TokenKind.identifier;
/*    
    TokenID = tok.TokenKind.identifier;
    ObjCOrBuiltinID = 0;
    HasMacro = false;
    HadMacro = false;
    IsExtension = false;
    IsFutureCompatKeyword = false;
    IsPoisoned = false;
    IsCPPOperatorKeyword = false;
    NeedsHandleIdentifier = false;
    IsFromAST = false;
    ChangedAfterLoad = false;
    FEChangedAfterLoad = false;
    RevertedTokenID = false;
    OutOfDate = false;
    IsModulesImport = false;
    FETokenInfo = null;
    Entry = null;    
*/    
    assert getTokenID() == tok.TokenKind.identifier;
    FETokenInfo = NO_ENTRY_AND_VALUE;
  }
  
  public IdentifierInfo(byte Str[], int fromIdx, int Len, int FullHashValue) {
    super(Str, fromIdx, Len, FullHashValue);
    Union_Flags = tok.TokenKind.identifier;
/*    
    TokenID = tok.TokenKind.identifier;
    ObjCOrBuiltinID = 0;
    HasMacro = false;
    HadMacro = false;
    IsExtension = false;
    IsCXX11CompatKeyword = false;
    IsPoisoned = false;
    IsCPPOperatorKeyword = false;
    NeedsHandleIdentifier = false;
    IsFromAST = false;
    ChangedAfterLoad = false;
    FEChangedAfterLoad = false;
    RevertedTokenID = false;
    OutOfDate = false;
    IsModulesImport = false;
    FETokenInfo = null;
    Entry = null;      
*/    
    assert getTokenID() == tok.TokenKind.identifier;
    FETokenInfo = NO_ENTRY_AND_VALUE;
  }

  /**
   * implement hook which allows to reuse StringMap with it's StringMapEntry table
   */
  @Override
  protected void resetStringMapEntryToInitialState() {
    Union_Flags = tok.TokenKind.identifier;
    FETokenInfo = null;
  }
  
  /// \brief Return true if this is the identifier for the specified string.
  ///
  /// This is intended to be used for string literals only: II->isStr("foo").
  /*template <std::size_t StrLen> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::IdentifierInfo::isStr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, 
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 93,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 89,
   FQN="clang::IdentifierInfo::isStr", NM="Tpl__ZNK5clang14IdentifierInfo5isStrERAT__Kc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=Tpl__ZNK5clang14IdentifierInfo5isStrERAT__Kc")
  //</editor-fold>
  public boolean isStr(String Str) /*const*/ {
    int StrLen = Str.length();
    IdentifierInfoStringMapEntry E = getEntryImpl();
    return (memcmp_null_termed(Str, 0, E.getKeyArray(), E.getKeyArrayIndex(), StrLen) == 0);
  }

  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public StringMapEntryBase getEntry() {
    return getEntryImpl();
  }
  
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  IdentifierInfoStringMapEntry getEntryImpl() {
    return FETokenInfo == NO_ENTRY_AND_VALUE ? null : this;
  }
  
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  void setEntry(IdentifierInfoStringMapEntry Entry) {
    assert Entry != null;
    assert Entry == this;
  }
  
  @Converted(kind = Converted.Kind.MANUAL_ADDED)  
  public final IdentifierInfo /*&*/ getValue$Const() {
    return FETokenInfo == NO_ENTRY_AND_VALUE ? null : this;
  }
  
  @Converted(kind = Converted.Kind.MANUAL_ADDED)  
  public final IdentifierInfo /*&*/ getValue() {
    return getValue$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StringMapEntryIdentifierInfo::setValue">
  @Converted(kind = Converted.Kind.AUTO, 
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/StringMap.h", line = 135,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringMap.cpp -filter=llvm::StringMapEntryIdentifierInfo::setValue")
  //</editor-fold>
  public void setValue(/*const*/IdentifierInfo /*&*/ V) {
    assert FETokenInfo == NO_ENTRY_AND_VALUE;
    // clean up marker, now field can be used
    FETokenInfo = null;
    // copy data
    this.FETokenInfo = V.FETokenInfo;
    this.Union_Flags = V.Union_Flags;
  }
  
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public void $completeJavaPTHCreation() {
    assert FETokenInfo == NO_ENTRY_AND_VALUE : "must be called only once";
    // clean up marker, now field can be used
    FETokenInfo = null;
  }
  
  /// \brief Return the beginning of the actual null-terminated string for this
  /// identifier.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::IdentifierInfo::getNameStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 100,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 97,
   FQN="clang::IdentifierInfo::getNameStart", NM="_ZNK5clang14IdentifierInfo12getNameStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZNK5clang14IdentifierInfo12getNameStartEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getNameStart() /*const*/ {
    // PERF: instead of this method you can use
    // StringMapEntryBase PPIdentifier = II.getEntry();
    // PPIdentifier.getKeyArray(), PPIdentifier.getKeyArrayIndex()
    
    if ((getEntryImpl() != null)) {
      return getEntryImpl().getKeyData();
    }
    assert false : "we had to freeze Entry from PTH as well, see PTHManager.LazilyCreateIdentifierInfo; forgot $completeJavaPTHCreation?";
    // FIXME: This is gross. It would be best not to embed specific details
    // of the PTH file format here.
    // The 'this' pointer really points to a
    // std::pair<IdentifierInfo, const char*>, where internal pointer
    // points to the external string data.
    /*typedef std::pair<IdentifierInfo, const char *> actualtype*/
//    public final class actualtype extends std.pair<IdentifierInfo, /*const*/char$ptr/*char P*/ >{ };
    if (true) throw new IllegalStateException("depends on PTH handling");
    return ((/*const*/std.pair<IdentifierInfo, /*const*/char$ptr/*char P*/ > /*P*/ )(Object)this).second;
  }

  
  /// \brief Efficiently return the length of this identifier info.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::IdentifierInfo::getLength">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 113,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 110,
   FQN="clang::IdentifierInfo::getLength", NM="_ZNK5clang14IdentifierInfo9getLengthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZNK5clang14IdentifierInfo9getLengthEv")
  //</editor-fold>
  public /*uint*/int getLength() /*const*/ {
    if ((getEntryImpl() != null)) {
      return getEntryImpl().getKeyLength();
    }
    assert false : "we had to freeze Entry from PTH as well, see PTHManager.LazilyCreateIdentifierInfo; forgot $completeJavaPTHCreation?";
    // FIXME: This is gross. It would be best not to embed specific details
    // of the PTH file format here.
    // The 'this' pointer really points to a
    // std::pair<IdentifierInfo, const char*>, where internal pointer
    // points to the external string data.
    /*typedef std::pair<IdentifierInfo, const char *> actualtype*/
//    public final class actualtype extends std.pair<IdentifierInfo, /*const*/char$ptr/*char P*/ >{ };
    if (true) throw new IllegalStateException("depends on PTH handling");
    /*const*/char$ptr/*char P*/ p = ((/*const*/std.pair<IdentifierInfo, /*const*/char$ptr/*char P*/ > /*P*/ )(Object)this).second.$sub(2);
    return (((/*uint*/int)p.$at(0)) | (((/*uint*/int)p.$at(1)) << 8)) - 1;
  }

  
  /// \brief Return the actual identifier string.
  //<editor-fold defaultstate="collapsed" desc="clang::IdentifierInfo::getName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 126,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 123,
   FQN="clang::IdentifierInfo::getName", NM="_ZNK5clang14IdentifierInfo7getNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZNK5clang14IdentifierInfo7getNameEv")
  //</editor-fold>
  public StringRef getName() /*const*/ {
    IdentifierInfoStringMapEntry Entry = getEntryImpl();
    return new StringRef(Entry.getKeyArray(), Entry.getKeyArrayIndex(), Entry.getKeyLength());
  }

  
  /// \brief Return true if this identifier is \#defined to some other value.
  /// \note The current definition may be in a module and not currently visible.
  //<editor-fold defaultstate="collapsed" desc="clang::IdentifierInfo::hasMacroDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 132,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 129,
   FQN="clang::IdentifierInfo::hasMacroDefinition", NM="_ZNK5clang14IdentifierInfo18hasMacroDefinitionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZNK5clang14IdentifierInfo18hasMacroDefinitionEv")
  //</editor-fold>
  public boolean hasMacroDefinition() /*const*/ {
    return BitFieldsUtils.getMaskedBit64(Union_Flags, HasMacro);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::IdentifierInfo::setHasMacroDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 135,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 132,
   FQN="clang::IdentifierInfo::setHasMacroDefinition", NM="_ZN5clang14IdentifierInfo21setHasMacroDefinitionEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZN5clang14IdentifierInfo21setHasMacroDefinitionEb")
  //</editor-fold>
  public void setHasMacroDefinition(boolean Val) {
    if (hasMacroDefinition() == Val) {
      return;
    }
    
    Union_Flags = BitFieldsUtils.setMaskedBit64(Union_Flags, HasMacro, Val);
    if (Val) {
      setNeedsHandleIdentifier(true);
      Union_Flags = BitFieldsUtils.setMaskedBit64(Union_Flags, HadMacro, true);
    } else {
      RecomputeNeedsHandleIdentifier();
    }
  }

  /// \brief Returns true if this identifier was \#defined to some value at any
  /// moment. In this case there should be an entry for the identifier in the
  /// macro history table in Preprocessor.
  //<editor-fold defaultstate="collapsed" desc="clang::IdentifierInfo::hadMacroDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 149,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 146,
   FQN="clang::IdentifierInfo::hadMacroDefinition", NM="_ZNK5clang14IdentifierInfo18hadMacroDefinitionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZNK5clang14IdentifierInfo18hadMacroDefinitionEv")
  //</editor-fold>
  public boolean hadMacroDefinition() /*const*/ {
    return BitFieldsUtils.getMaskedBit64(Union_Flags, HadMacro);
  }

  
  /// If this is a source-language token (e.g. 'for'), this API
  /// can be used to cause the lexer to map identifiers to source-language
  /// tokens.
  //<editor-fold defaultstate="collapsed" desc="clang::IdentifierInfo::getTokenID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 156,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 153,
   FQN="clang::IdentifierInfo::getTokenID", NM="_ZNK5clang14IdentifierInfo10getTokenIDEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZNK5clang14IdentifierInfo10getTokenIDEv")
  //</editor-fold>
  public final /*tok.TokenKind*/char getTokenID() /*const*/ {
    long out = BitFieldsUtils.getLastMaskedBits64(Union_Flags, TokenID_Mask);
    return Unsigned.$long2ushort(out);
  }

  int $TokenID() {
    long out = BitFieldsUtils.getLastMaskedBits64(Union_Flags, TokenID_Mask);
    return Unsigned.$long2uint(out);
  }
  
  void setTokenID(/*tok.TokenKind*/char kindID) /*const*/ {
    assert Unsigned.$ushort2ulong(kindID) == (long)kindID : "implicit conversion in the call below going to be incorrect:"
            + Long.toHexString((long)kindID) + " vs. " + Long.toHexString(Unsigned.$ushort2ulong(kindID)); // NOI18N
    Union_Flags = BitFieldsUtils.setLastMaskedBits64(Union_Flags, TokenID_Clear, kindID);
  }

  
  /// \brief True if revertTokenIDToIdentifier() was called.
  //<editor-fold defaultstate="collapsed" desc="clang::IdentifierInfo::hasRevertedTokenIDToIdentifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 159,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 156,
   FQN="clang::IdentifierInfo::hasRevertedTokenIDToIdentifier", NM="_ZNK5clang14IdentifierInfo30hasRevertedTokenIDToIdentifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZNK5clang14IdentifierInfo30hasRevertedTokenIDToIdentifierEv")
  //</editor-fold>
  public boolean hasRevertedTokenIDToIdentifier() /*const*/ {
    return BitFieldsUtils.getMaskedBit64(Union_Flags, RevertedTokenID);
  }

  
  /// \brief Revert TokenID to tok::identifier; used for GNU libstdc++ 4.2
  /// compatibility.
  ///
  /// TokenID is normally read-only but there are 2 instances where we revert it
  /// to tok::identifier for libstdc++ 4.2. Keep track of when this happens
  /// using this method so we can inform serialization about it.
  //<editor-fold defaultstate="collapsed" desc="clang::IdentifierInfo::revertTokenIDToIdentifier">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 167,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 164,
   FQN="clang::IdentifierInfo::revertTokenIDToIdentifier", NM="_ZN5clang14IdentifierInfo25revertTokenIDToIdentifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZN5clang14IdentifierInfo25revertTokenIDToIdentifierEv")
  //</editor-fold>
  public void revertTokenIDToIdentifier() {
    assert (getTokenID() != tok.TokenKind.identifier) : "Already at tok::identifier";
    Union_Flags = BitFieldsUtils.setLastBits64(Union_Flags, TokenID, tok.TokenKind.identifier);
    Union_Flags = BitFieldsUtils.setMaskedBit64(Union_Flags, RevertedTokenID, true);
  }
  
  //<editor-fold defaultstate="collapsed" desc="clang::IdentifierInfo::revertIdentifierToTokenID">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 172,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 169,
   FQN="clang::IdentifierInfo::revertIdentifierToTokenID", NM="_ZN5clang14IdentifierInfo25revertIdentifierToTokenIDENS_3tok9TokenKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZN5clang14IdentifierInfo25revertIdentifierToTokenIDENS_3tok9TokenKindE")
  //</editor-fold>
  public void revertIdentifierToTokenID(/*tok.TokenKind*/char TK) {
    assert (getTokenID() == $ushort2int(tok.TokenKind.identifier)) : "Should be at tok::identifier: " + tok.$kind2String(getTokenID());
    Union_Flags = BitFieldsUtils.setLastBits64(Union_Flags, TokenID, TK);
    Union_Flags = BitFieldsUtils.setMaskedBit64(Union_Flags, RevertedTokenID, false);
  }
  
  
  /// \brief Return the preprocessor keyword ID for this identifier.
  ///
  /// For example, "define" will return tok::pp_define.
  //<editor-fold defaultstate="collapsed" desc="clang::IdentifierInfo::getPPKeywordID">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", line = 255,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", old_line = 254,
   FQN="clang::IdentifierInfo::getPPKeywordID", NM="_ZNK5clang14IdentifierInfo14getPPKeywordIDEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZNK5clang14IdentifierInfo14getPPKeywordIDEv")
  //</editor-fold>
  public /*tok.PPKeywordKind*/char getPPKeywordID() /*const*/ {
    
    /*uint*/int Len = getLength();
    if (Len < 2) {
      return tok.PPKeywordKind.pp_not_keyword;
    }
//    /*const*/char$ptr/*char P*/ Name = getNameStart();
    IdentifierInfoStringMapEntry E = getEntryImpl();
    byte[] Name = E.getKeyArray();
    int NameIndex = E.getKeyArrayIndex();
    switch ((Len << 5) + (((Name[NameIndex + 0] - 'a') + (Name[NameIndex + 2] - 'a')) & 31)) {
     default:
      return tok.PPKeywordKind.pp_not_keyword;
     case (2 << 5) + ((('i' - 'a') + ('\0' - 'a')) & 31):
      return (memcmp(Name, NameIndex, "if", 2) != 0) ? tok.PPKeywordKind.pp_not_keyword : tok.PPKeywordKind.pp_if;
     case (4 << 5) + ((('e' - 'a') + ('i' - 'a')) & 31):
      return (memcmp(Name, NameIndex, "elif", 4) != 0) ? tok.PPKeywordKind.pp_not_keyword : tok.PPKeywordKind.pp_elif;
     case (4 << 5) + ((('e' - 'a') + ('s' - 'a')) & 31):
      return (memcmp(Name, NameIndex, "else", 4) != 0) ? tok.PPKeywordKind.pp_not_keyword : tok.PPKeywordKind.pp_else;
     case (4 << 5) + ((('l' - 'a') + ('n' - 'a')) & 31):
      return (memcmp(Name, NameIndex, "line", 4) != 0) ? tok.PPKeywordKind.pp_not_keyword : tok.PPKeywordKind.pp_line;
     case (4 << 5) + ((('s' - 'a') + ('c' - 'a')) & 31):
      return (memcmp(Name, NameIndex, "sccs", 4) != 0) ? tok.PPKeywordKind.pp_not_keyword : tok.PPKeywordKind.pp_sccs;
     case (5 << 5) + ((('e' - 'a') + ('d' - 'a')) & 31):
      return (memcmp(Name, NameIndex, "endif", 5) != 0) ? tok.PPKeywordKind.pp_not_keyword : tok.PPKeywordKind.pp_endif;
     case (5 << 5) + ((('e' - 'a') + ('r' - 'a')) & 31):
      return (memcmp(Name, NameIndex, "error", 5) != 0) ? tok.PPKeywordKind.pp_not_keyword : tok.PPKeywordKind.pp_error;
     case (5 << 5) + ((('i' - 'a') + ('e' - 'a')) & 31):
      return (memcmp(Name, NameIndex, "ident", 5) != 0) ? tok.PPKeywordKind.pp_not_keyword : tok.PPKeywordKind.pp_ident;
     case (5 << 5) + ((('i' - 'a') + ('d' - 'a')) & 31):
      return (memcmp(Name, NameIndex, "ifdef", 5) != 0) ? tok.PPKeywordKind.pp_not_keyword : tok.PPKeywordKind.pp_ifdef;
     case (5 << 5) + ((('u' - 'a') + ('d' - 'a')) & 31):
      return (memcmp(Name, NameIndex, "undef", 5) != 0) ? tok.PPKeywordKind.pp_not_keyword : tok.PPKeywordKind.pp_undef;
     case (6 << 5) + ((('a' - 'a') + ('s' - 'a')) & 31):
      return (memcmp(Name, NameIndex, "assert", 6) != 0) ? tok.PPKeywordKind.pp_not_keyword : tok.PPKeywordKind.pp_assert;
     case (6 << 5) + ((('d' - 'a') + ('f' - 'a')) & 31):
      return (memcmp(Name, NameIndex, "define", 6) != 0) ? tok.PPKeywordKind.pp_not_keyword : tok.PPKeywordKind.pp_define;
     case (6 << 5) + ((('i' - 'a') + ('n' - 'a')) & 31):
      return (memcmp(Name, NameIndex, "ifndef", 6) != 0) ? tok.PPKeywordKind.pp_not_keyword : tok.PPKeywordKind.pp_ifndef;
     case (6 << 5) + ((('i' - 'a') + ('p' - 'a')) & 31):
      return (memcmp(Name, NameIndex, "import", 6) != 0) ? tok.PPKeywordKind.pp_not_keyword : tok.PPKeywordKind.pp_import;
     case (6 << 5) + ((('p' - 'a') + ('a' - 'a')) & 31):
      return (memcmp(Name, NameIndex, "pragma", 6) != 0) ? tok.PPKeywordKind.pp_not_keyword : tok.PPKeywordKind.pp_pragma;
     case (7 << 5) + ((('d' - 'a') + ('f' - 'a')) & 31):
      return (memcmp(Name, NameIndex, "defined", 7) != 0) ? tok.PPKeywordKind.pp_not_keyword : tok.PPKeywordKind.pp_defined;
     case (7 << 5) + ((('i' - 'a') + ('c' - 'a')) & 31):
      return (memcmp(Name, NameIndex, "include", 7) != 0) ? tok.PPKeywordKind.pp_not_keyword : tok.PPKeywordKind.pp_include;
     case (7 << 5) + ((('w' - 'a') + ('r' - 'a')) & 31):
      return (memcmp(Name, NameIndex, "warning", 7) != 0) ? tok.PPKeywordKind.pp_not_keyword : tok.PPKeywordKind.pp_warning;
     case (8 << 5) + ((('u' - 'a') + ('a' - 'a')) & 31):
      return (memcmp(Name, NameIndex, "unassert", 8) != 0) ? tok.PPKeywordKind.pp_not_keyword : tok.PPKeywordKind.pp_unassert;
     case (12 << 5) + ((('i' - 'a') + ('c' - 'a')) & 31):
      return (memcmp(Name, NameIndex, "include_next", 12) != 0) ? tok.PPKeywordKind.pp_not_keyword : tok.PPKeywordKind.pp_include_next;
     case (14 << 5) + ((('_' - 'a') + ('p' - 'a')) & 31):
      return (memcmp(Name, NameIndex, "__public_macro", 14) != 0) ? tok.PPKeywordKind.pp_not_keyword : tok.PPKeywordKind.pp___public_macro;
     case (15 << 5) + ((('_' - 'a') + ('p' - 'a')) & 31):
      return (memcmp(Name, NameIndex, "__private_macro", 15) != 0) ? tok.PPKeywordKind.pp_not_keyword : tok.PPKeywordKind.pp___private_macro;
     case (16 << 5) + ((('_' - 'a') + ('i' - 'a')) & 31):
      return (memcmp(Name, NameIndex, "__include_macros", 16) != 0) ? tok.PPKeywordKind.pp_not_keyword : tok.PPKeywordKind.pp___include_macros;
    }
  }

  
  /// \brief Return the Objective-C keyword ID for the this identifier.
  ///
  /// For example, 'class' will return tok::objc_class if ObjC is enabled.
  //<editor-fold defaultstate="collapsed" desc="clang::IdentifierInfo::getObjCKeywordID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 186,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 183,
   FQN="clang::IdentifierInfo::getObjCKeywordID", NM="_ZNK5clang14IdentifierInfo16getObjCKeywordIDEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZNK5clang14IdentifierInfo16getObjCKeywordIDEv")
  //</editor-fold>
  public /*tok.ObjCKeywordKind*/char getObjCKeywordID() /*const*/ {
    /*uint*/int objCOrBuiltinID = getObjCOrBuiltinID();
    if (objCOrBuiltinID < tok.ObjCKeywordKind.NUM_OBJC_KEYWORDS) {
      return $uint2ushort(objCOrBuiltinID);
    } else {
      return tok.ObjCKeywordKind.objc_not_keyword;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::IdentifierInfo::setObjCKeywordID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 192,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 189,
   FQN="clang::IdentifierInfo::setObjCKeywordID", NM="_ZN5clang14IdentifierInfo16setObjCKeywordIDENS_3tok15ObjCKeywordKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZN5clang14IdentifierInfo16setObjCKeywordIDENS_3tok15ObjCKeywordKindE")
  //</editor-fold>
  public void setObjCKeywordID(/*tok.ObjCKeywordKind*/char ID) {
    setObjCOrBuiltinID(ID);
  }

  
  /// \brief True if setNotBuiltin() was called.
  //<editor-fold defaultstate="collapsed" desc="clang::IdentifierInfo::hasRevertedBuiltin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 195,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 192,
   FQN="clang::IdentifierInfo::hasRevertedBuiltin", NM="_ZNK5clang14IdentifierInfo18hasRevertedBuiltinEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZNK5clang14IdentifierInfo18hasRevertedBuiltinEv")
  //</editor-fold>
  public boolean hasRevertedBuiltin() /*const*/ {
    return ObjCOrBuiltinID == tok.ObjCKeywordKind.NUM_OBJC_KEYWORDS;
  }
  
  
  /// \brief Revert the identifier to a non-builtin identifier. We do this if
  /// the name of a known builtin library function is used to declare that
  /// function, but an unexpected type is specified.
  //<editor-fold defaultstate="collapsed" desc="clang::IdentifierInfo::revertBuiltin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 202,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 199,
   FQN="clang::IdentifierInfo::revertBuiltin", NM="_ZN5clang14IdentifierInfo13revertBuiltinEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZN5clang14IdentifierInfo13revertBuiltinEv")
  //</editor-fold>
  public void revertBuiltin() {
    setBuiltinID(0);
  }
  
  
  /// \brief Return a value indicating whether this is a builtin function.
  ///
  /// 0 is not-built-in.  1 is builtin-for-some-nonprimary-target.
  /// 2+ are specific builtin functions.
  //<editor-fold defaultstate="collapsed" desc="clang::IdentifierInfo::getBuiltinID">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 210,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 207,
   FQN="clang::IdentifierInfo::getBuiltinID", NM="_ZNK5clang14IdentifierInfo12getBuiltinIDEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZNK5clang14IdentifierInfo12getBuiltinIDEv")
  //</editor-fold>
  public /*uint*/int getBuiltinID() /*const*/ {
    int objCOrBuiltinID = getObjCOrBuiltinID();
    if (objCOrBuiltinID >= tok.ObjCKeywordKind.NUM_OBJC_KEYWORDS) {
      return objCOrBuiltinID - tok.ObjCKeywordKind.NUM_OBJC_KEYWORDS;
    } else {
      return 0;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::IdentifierInfo::setBuiltinID">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 216,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 213,
   FQN="clang::IdentifierInfo::setBuiltinID", NM="_ZN5clang14IdentifierInfo12setBuiltinIDEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZN5clang14IdentifierInfo12setBuiltinIDEj")
  //</editor-fold>
  public void setBuiltinID(/*uint*/int ID) {
    setObjCOrBuiltinID((ID + tok.ObjCKeywordKind.NUM_OBJC_KEYWORDS));
    assert (getObjCOrBuiltinID() - (/*uint*/int)(tok.ObjCKeywordKind.NUM_OBJC_KEYWORDS) == ID) : "ID too large for field!";
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::IdentifierInfo::getObjCOrBuiltinID">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 222,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 219,
   FQN="clang::IdentifierInfo::getObjCOrBuiltinID", NM="_ZNK5clang14IdentifierInfo18getObjCOrBuiltinIDEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZNK5clang14IdentifierInfo18getObjCOrBuiltinIDEv")
  //</editor-fold>
  public /*uint*/int getObjCOrBuiltinID() /*const*/ {
    long out = BitFieldsUtils.getMiddleBits64(Union_Flags, ObjCOrBuiltinID, ObjCOrBuiltinIDBits);
    return Unsigned.$long2uint(out);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::IdentifierInfo::setObjCOrBuiltinID">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 223,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 220,
   FQN="clang::IdentifierInfo::setObjCOrBuiltinID", NM="_ZN5clang14IdentifierInfo18setObjCOrBuiltinIDEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZN5clang14IdentifierInfo18setObjCOrBuiltinIDEj")
  //</editor-fold>
  public void setObjCOrBuiltinID(/*uint*/int ID) {
    Union_Flags = BitFieldsUtils.setMiddleBits64(Union_Flags, ObjCOrBuiltinID, ObjCOrBuiltinIDBits, ID);
  }

  
  /// get/setExtension - Initialize information about whether or not this
  /// language token is an extension.  This controls extension warnings, and is
  /// only valid if a custom token ID is set.
  //<editor-fold defaultstate="collapsed" desc="clang::IdentifierInfo::isExtensionToken">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 228,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 225,
   FQN="clang::IdentifierInfo::isExtensionToken", NM="_ZNK5clang14IdentifierInfo16isExtensionTokenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZNK5clang14IdentifierInfo16isExtensionTokenEv")
  //</editor-fold>
  public boolean isExtensionToken() /*const*/ {
    return BitFieldsUtils.getMaskedBit64(Union_Flags, IsExtension);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::IdentifierInfo::setIsExtensionToken">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 229,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 226,
   FQN="clang::IdentifierInfo::setIsExtensionToken", NM="_ZN5clang14IdentifierInfo19setIsExtensionTokenEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZN5clang14IdentifierInfo19setIsExtensionTokenEb")
  //</editor-fold>
  public void setIsExtensionToken(boolean Val) {
    Union_Flags = BitFieldsUtils.setMaskedBit64(Union_Flags, IsExtension, Val);
    if (Val) {
      setNeedsHandleIdentifier(true);
    } else {
      RecomputeNeedsHandleIdentifier();
    }
  }

  
  /// is/setIsFutureCompatKeyword - Initialize information about whether or not
  /// this language token is a keyword in a newer or proposed Standard. This
  /// controls compatibility warnings, and is only true when not parsing the
  /// corresponding Standard. Once a compatibility problem has been diagnosed
  /// with this keyword, the flag will be cleared.
  //<editor-fold defaultstate="collapsed" desc="clang::IdentifierInfo::isFutureCompatKeyword">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 242,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 239,
   FQN="clang::IdentifierInfo::isFutureCompatKeyword", NM="_ZNK5clang14IdentifierInfo21isFutureCompatKeywordEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZNK5clang14IdentifierInfo21isFutureCompatKeywordEv")
  //</editor-fold>
  public boolean isFutureCompatKeyword() /*const*/ {
    return BitFieldsUtils.getMaskedBit64(Union_Flags, IsFutureCompatKeyword);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::IdentifierInfo::setIsFutureCompatKeyword">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 243,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 240,
   FQN="clang::IdentifierInfo::setIsFutureCompatKeyword", NM="_ZN5clang14IdentifierInfo24setIsFutureCompatKeywordEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZN5clang14IdentifierInfo24setIsFutureCompatKeywordEb")
  //</editor-fold>
  public void setIsFutureCompatKeyword(boolean Val) {
    Union_Flags = BitFieldsUtils.setMaskedBit64(Union_Flags, IsFutureCompatKeyword, Val);
    if (Val) {
      setNeedsHandleIdentifier(true);
    } else {
      RecomputeNeedsHandleIdentifier();
    }
  }

  
  /// setIsPoisoned - Mark this identifier as poisoned.  After poisoning, the
  /// Preprocessor will emit an error every time this token is used.
  //<editor-fold defaultstate="collapsed" desc="clang::IdentifierInfo::setIsPoisoned">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 253,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 250,
   FQN="clang::IdentifierInfo::setIsPoisoned", NM="_ZN5clang14IdentifierInfo13setIsPoisonedEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZN5clang14IdentifierInfo13setIsPoisonedEb")
  //</editor-fold>
  public void setIsPoisoned() {
    setIsPoisoned(true);
  }
  public void setIsPoisoned(boolean Value/*= true*/) {
    Union_Flags = BitFieldsUtils.setMaskedBit64(Union_Flags, IsPoisoned, Value);
    if (Value) {
      setNeedsHandleIdentifier(true);
    } else {
      RecomputeNeedsHandleIdentifier();
    }
  }

  
  /// \brief Return true if this token has been poisoned.
  //<editor-fold defaultstate="collapsed" desc="clang::IdentifierInfo::isPoisoned">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 262,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 259,
   FQN="clang::IdentifierInfo::isPoisoned", NM="_ZNK5clang14IdentifierInfo10isPoisonedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZNK5clang14IdentifierInfo10isPoisonedEv")
  //</editor-fold>
  public boolean isPoisoned() /*const*/ {
    return BitFieldsUtils.getMaskedBit64(Union_Flags, IsPoisoned);
  }

  
  /// isCPlusPlusOperatorKeyword/setIsCPlusPlusOperatorKeyword controls whether
  /// this identifier is a C++ alternate representation of an operator.
  //<editor-fold defaultstate="collapsed" desc="clang::IdentifierInfo::setIsCPlusPlusOperatorKeyword">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 266,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 263,
   FQN="clang::IdentifierInfo::setIsCPlusPlusOperatorKeyword", NM="_ZN5clang14IdentifierInfo29setIsCPlusPlusOperatorKeywordEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZN5clang14IdentifierInfo29setIsCPlusPlusOperatorKeywordEb")
  //</editor-fold>
  public void setIsCPlusPlusOperatorKeyword() {
    setIsCPlusPlusOperatorKeyword(true);
  }
  public void setIsCPlusPlusOperatorKeyword(boolean Val/*= true*/) {
    Union_Flags = BitFieldsUtils.setMaskedBit64(Union_Flags, IsCPPOperatorKeyword, Val);
    if (Val) {
      setNeedsHandleIdentifier(true);
    } else {
      RecomputeNeedsHandleIdentifier();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::IdentifierInfo::isCPlusPlusOperatorKeyword">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 273,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 270,
   FQN="clang::IdentifierInfo::isCPlusPlusOperatorKeyword", NM="_ZNK5clang14IdentifierInfo26isCPlusPlusOperatorKeywordEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZNK5clang14IdentifierInfo26isCPlusPlusOperatorKeywordEv")
  //</editor-fold>
  public boolean isCPlusPlusOperatorKeyword() /*const*/ {
    return BitFieldsUtils.getMaskedBit64(Union_Flags, IsCPPOperatorKeyword);
  }
  
  
  /// \brief Return true if this token is a keyword in the specified language.
  
  /// \brief Returns true if the identifier represents a keyword in the
  /// specified language.
  //<editor-fold defaultstate="collapsed" desc="clang::IdentifierInfo::isKeyword">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", line = 245,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", old_line = 244,
   FQN="clang::IdentifierInfo::isKeyword", NM="_ZN5clang14IdentifierInfo9isKeywordERKNS_11LangOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZN5clang14IdentifierInfo9isKeywordERKNS_11LangOptionsE")
  //</editor-fold>
  public boolean isKeyword(/*const*/ LangOptions /*&*/ LangOpts) {
    switch (getTokenKwStatus(LangOpts, getTokenID())) {
     case KS_Enabled:
     case KS_Extension:
      return true;
     default:
      return false;
    }
  }
  
  
  /// getFETokenInfo/setFETokenInfo - The language front-end is allowed to
  /// associate arbitrary metadata with this token.
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::IdentifierInfo::getFETokenInfo">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, 
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 281,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 277,
   FQN="clang::IdentifierInfo::getFETokenInfo", NM="Tpl__ZNK5clang14IdentifierInfo14getFETokenInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=Tpl__ZNK5clang14IdentifierInfo14getFETokenInfoEv")
  //</editor-fold>
  public </*typename*/ T> T /*P*/ getFETokenInfo() /*const*/ {
    assert FETokenInfo != NO_ENTRY_AND_VALUE; // MANUAL_SEMANTIC
    return (/*static_cast*/T /*P*/ )(FETokenInfo);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::IdentifierInfo::setFETokenInfo">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 282,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 279,
   FQN="clang::IdentifierInfo::setFETokenInfo", NM="_ZN5clang14IdentifierInfo14setFETokenInfoEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZN5clang14IdentifierInfo14setFETokenInfoEPv")
  //</editor-fold>
  public void setFETokenInfo(Object/*void P*/ T) {
    assert FETokenInfo != NO_ENTRY_AND_VALUE;
    FETokenInfo = T;
  }

  
  /// \brief Return true if the Preprocessor::HandleIdentifier must be called
  /// on a token of this identifier.
  ///
  /// If this returns false, we know that HandleIdentifier will not affect
  /// the token.
  //<editor-fold defaultstate="collapsed" desc="clang::IdentifierInfo::isHandleIdentifierCase">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 289,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 286,
   FQN="clang::IdentifierInfo::isHandleIdentifierCase", NM="_ZNK5clang14IdentifierInfo22isHandleIdentifierCaseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZNK5clang14IdentifierInfo22isHandleIdentifierCaseEv")
  //</editor-fold>
  public boolean isHandleIdentifierCase() /*const*/ {
    return BitFieldsUtils.getMaskedBit64(Union_Flags, NeedsHandleIdentifier);
  }

  
  /// \brief Return true if the identifier in its current state was loaded
  /// from an AST file.
  //<editor-fold defaultstate="collapsed" desc="clang::IdentifierInfo::isFromAST">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 293,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 290,
   FQN="clang::IdentifierInfo::isFromAST", NM="_ZNK5clang14IdentifierInfo9isFromASTEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZNK5clang14IdentifierInfo9isFromASTEv")
  //</editor-fold>
  public boolean isFromAST() /*const*/ {
    return BitFieldsUtils.getMaskedBit64(Union_Flags, IsFromAST);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::IdentifierInfo::setIsFromAST">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 295,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 292,
   FQN="clang::IdentifierInfo::setIsFromAST", NM="_ZN5clang14IdentifierInfo12setIsFromASTEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZN5clang14IdentifierInfo12setIsFromASTEv")
  //</editor-fold>
  public void setIsFromAST() {
    Union_Flags = BitFieldsUtils.setMaskedBit64(Union_Flags, IsFromAST, true);
  }

  
  /// \brief Determine whether this identifier has changed since it was loaded
  /// from an AST file.
  //<editor-fold defaultstate="collapsed" desc="clang::IdentifierInfo::hasChangedSinceDeserialization">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 299,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 296,
   FQN="clang::IdentifierInfo::hasChangedSinceDeserialization", NM="_ZNK5clang14IdentifierInfo30hasChangedSinceDeserializationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZNK5clang14IdentifierInfo30hasChangedSinceDeserializationEv")
  //</editor-fold>
  public boolean hasChangedSinceDeserialization() /*const*/ {
    return BitFieldsUtils.getMaskedBit64(Union_Flags, ChangedAfterLoad);
  }

  
  /// \brief Note that this identifier has changed since it was loaded from
  /// an AST file.
  //<editor-fold defaultstate="collapsed" desc="clang::IdentifierInfo::setChangedSinceDeserialization">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 305,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 302,
   FQN="clang::IdentifierInfo::setChangedSinceDeserialization", NM="_ZN5clang14IdentifierInfo30setChangedSinceDeserializationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZN5clang14IdentifierInfo30setChangedSinceDeserializationEv")
  //</editor-fold>
  public void setChangedSinceDeserialization() {
    Union_Flags = BitFieldsUtils.setMaskedBit64(Union_Flags, ChangedAfterLoad, true);
  }

  
  /// \brief Determine whether the frontend token information for this
  /// identifier has changed since it was loaded from an AST file.
  //<editor-fold defaultstate="collapsed" desc="clang::IdentifierInfo::hasFETokenInfoChangedSinceDeserialization">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 311,
   FQN="clang::IdentifierInfo::hasFETokenInfoChangedSinceDeserialization", NM="_ZNK5clang14IdentifierInfo41hasFETokenInfoChangedSinceDeserializationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZNK5clang14IdentifierInfo41hasFETokenInfoChangedSinceDeserializationEv")
  //</editor-fold>
  public boolean hasFETokenInfoChangedSinceDeserialization() /*const*/ {
    return BitFieldsUtils.getMaskedBit64(Union_Flags, FEChangedAfterLoad);
  }

  
  /// \brief Note that the frontend token information for this identifier has
  /// changed since it was loaded from an AST file.
  //<editor-fold defaultstate="collapsed" desc="clang::IdentifierInfo::setFETokenInfoChangedSinceDeserialization">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 317,
   FQN="clang::IdentifierInfo::setFETokenInfoChangedSinceDeserialization", NM="_ZN5clang14IdentifierInfo41setFETokenInfoChangedSinceDeserializationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZN5clang14IdentifierInfo41setFETokenInfoChangedSinceDeserializationEv")
  //</editor-fold>
  public void setFETokenInfoChangedSinceDeserialization() {
    Union_Flags = BitFieldsUtils.setMaskedBit64(Union_Flags, FEChangedAfterLoad, true);
  }

  
  /// \brief Determine whether the information for this identifier is out of
  /// date with respect to the external source.
  //<editor-fold defaultstate="collapsed" desc="clang::IdentifierInfo::isOutOfDate">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 323,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 308,
   FQN="clang::IdentifierInfo::isOutOfDate", NM="_ZNK5clang14IdentifierInfo11isOutOfDateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZNK5clang14IdentifierInfo11isOutOfDateEv")
  //</editor-fold>
  public boolean isOutOfDate() /*const*/ {
    return BitFieldsUtils.getMaskedBit64(Union_Flags, OutOfDate);
  }

  
  /// \brief Set whether the information for this identifier is out of
  /// date with respect to the external source.
  //<editor-fold defaultstate="collapsed" desc="clang::IdentifierInfo::setOutOfDate">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 327,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 312,
   FQN="clang::IdentifierInfo::setOutOfDate", NM="_ZN5clang14IdentifierInfo12setOutOfDateEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZN5clang14IdentifierInfo12setOutOfDateEb")
  //</editor-fold>
  public void setOutOfDate(boolean OOD) {
    Union_Flags = BitFieldsUtils.setMaskedBit64(Union_Flags, OutOfDate, OOD);
    if (OOD) {
      setNeedsHandleIdentifier(true);
    } else {
      RecomputeNeedsHandleIdentifier();
    }
  }

  
  /// \brief Determine whether this is the contextual keyword \c import.
  //<editor-fold defaultstate="collapsed" desc="clang::IdentifierInfo::isModulesImport">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 336,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 321,
   FQN="clang::IdentifierInfo::isModulesImport", NM="_ZNK5clang14IdentifierInfo15isModulesImportEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZNK5clang14IdentifierInfo15isModulesImportEv")
  //</editor-fold>
  public boolean isModulesImport() /*const*/ {
    return BitFieldsUtils.getMaskedBit64(Union_Flags, IsModulesImport);
  }

  
  /// \brief Set whether this identifier is the contextual keyword \c import.
  //<editor-fold defaultstate="collapsed" desc="clang::IdentifierInfo::setModulesImport">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 339,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 324,
   FQN="clang::IdentifierInfo::setModulesImport", NM="_ZN5clang14IdentifierInfo16setModulesImportEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZN5clang14IdentifierInfo16setModulesImportEb")
  //</editor-fold>
  public void setModulesImport(boolean I) {
    Union_Flags = BitFieldsUtils.setMaskedBit64(Union_Flags, IsModulesImport, I);
    if (I) {
      setNeedsHandleIdentifier(true);
    } else {
      RecomputeNeedsHandleIdentifier();
    }
  }
  
  
  /// \brief Provide less than operator for lexicographical sorting.
  //<editor-fold defaultstate="collapsed" desc="clang::IdentifierInfo::operator<">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 348,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 333,
   FQN="clang::IdentifierInfo::operator<", NM="_ZNK5clang14IdentifierInfoltERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZNK5clang14IdentifierInfoltERKS0_")
  //</editor-fold>
  public boolean $less(/*const*/ IdentifierInfo /*&*/ RHS) /*const*/ {
    return $less_StringRef(getName(), RHS.getName());
  }
  public static final Comparator<IdentifierInfo> COMPARATOR = new Comparator<IdentifierInfo>() {
    @Override
    public int compare(IdentifierInfo o1, IdentifierInfo o2) {
      if (o1 == o2) {
        return 0;
      }
      if (o1.$less(o2)) {
        return -1;
      } else if (o2.$less(o1)) {
        return 1;
      }
      return 0;
    }
  };
  
/*private:*/
  /// The Preprocessor::HandleIdentifier does several special (but rare)
  /// things to identifiers of various sorts.  For example, it changes the
  /// \c for keyword token from tok::identifier to tok::for.
  ///
  /// This method is very tied to the definition of HandleIdentifier.  Any
  /// change to it should be reflected here.
  //<editor-fold defaultstate="collapsed" desc="clang::IdentifierInfo::RecomputeNeedsHandleIdentifier">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 359,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 344,
   FQN="clang::IdentifierInfo::RecomputeNeedsHandleIdentifier", NM="_ZN5clang14IdentifierInfo30RecomputeNeedsHandleIdentifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZN5clang14IdentifierInfo30RecomputeNeedsHandleIdentifierEv")
  //</editor-fold>
  private void RecomputeNeedsHandleIdentifier() {
    // JAVA: fixed FindBugs NS_DANGEROUS_NON_SHORT_CIRCUIT
    setNeedsHandleIdentifier(isPoisoned() || hasMacroDefinition() || (isCPlusPlusOperatorKeyword()) 
            || (isExtensionToken()) || (isFutureCompatKeyword()) || isOutOfDate() 
            || isModulesImport());
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override
  public boolean $less(Object obj) {
    return $less((IdentifierInfo)obj);
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    if (this == IdentifierInfo.DMI$IdentifierInfoPtr.getEmptyKey()) {
      return "EMPTY_INDENTIFIER_INFO_PTR_ENTRY";
    }
    if (this == IdentifierInfo.DMI$IdentifierInfoPtr.getTombstoneKey()) {
      return "TOMBSTONE_INDENTIFIER_INFO_PTR_ENTRY";
    }    
    String FETokenInfoStr;
    if (FETokenInfo == NO_ENTRY_AND_VALUE) {
      FETokenInfoStr = "NO_ENTRY_AND_VALUE";      
    } else {
      FETokenInfoStr = NativeTrace.getIdentityStr(FETokenInfo);
    }
    return "IdentifierInfo{" 
            + (getEntryImpl() == null ? "[NoEnty]" : "Name=" + getName() + ", ") // NOI18N
            + "TokenID=(" + (int)getTokenID() + ")" + Native.$toString(tok.getTokenName(getTokenID())) // NOI18N
            + ", ObjCOrBuiltinID=" + (int)getObjCKeywordID() // NOI18N
            + ", HasMacro=" + hasMacroDefinition() // NOI18N
            + ", HadMacro=" + hadMacroDefinition() // NOI18N
            + ", IsExtension=" + isExtensionToken() // NOI18N
            + ", isFutureCompatKeyword=" + isFutureCompatKeyword() // NOI18N
            + ", IsPoisoned=" + isPoisoned() // NOI18N
            + ", IsCPPOperatorKeyword=" + isCPlusPlusOperatorKeyword() // NOI18N
            + ", NeedsHandleIdentifier=" + isHandleIdentifierCase() // NOI18N
            + ", IsFromAST=" + isFromAST() // NOI18N
            + ", ChangedAfterLoad=" + hasChangedSinceDeserialization() // NOI18N
            + ", FEChangedAfterLoad=" + hasFETokenInfoChangedSinceDeserialization() // NOI18N
            + ", RevertedTokenID=" + hasRevertedTokenIDToIdentifier() // NOI18N
            + ", OutOfDate=" + isOutOfDate() // NOI18N
            + ", IsModulesImport=" + isModulesImport() // NOI18N
            + ",FETokenInfo=[" + FETokenInfoStr + "]}"; // NOI18N
  }

  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  private void setNeedsHandleIdentifier(boolean val) {
    Union_Flags = BitFieldsUtils.setMaskedBit64(Union_Flags, NeedsHandleIdentifier, val);
  }
}
