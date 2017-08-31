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
import org.clank.java.*;
import org.clank.support.*;
import static org.clank.support.Unsigned.*;
import static org.clank.support.literal_constants.*;
import static org.clank.support.JavaDifferentiators.*;
import org.llvm.support.*;


/// \brief Encodes a location in the source. The SourceManager can decode this
/// to get at the full include stack, line and column information.
///
/// Technically, a source location is simply an offset into the manager's view
/// of the input source, which is all input buffers (including macro
/// expansions) concatenated in an effectively arbitrary order. The manager
/// actually maintains two blocks of input buffers. One, starting at offset
/// 0 and growing upwards, contains all buffers from this module. The other,
/// starting at the highest possible offset and growing downwards, contains
/// buffers of loaded modules.
///
/// In addition, one bit of SourceLocation is used for quick access to the
/// information whether the location is in a file or a macro expansion.
///
/// It is important that this type remains small. It is currently 32 bits wide.
//<editor-fold defaultstate="collapsed" desc="clang::SourceLocation">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 88,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 87,
 FQN = "clang::SourceLocation", NM = "_ZN5clang14SourceLocationE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang14SourceLocationE")
//</editor-fold>
public class SourceLocation implements Native.NativePOD<SourceLocation>, NativeType.SizeofCapable, NativeSwappable, NativeMoveable<SourceLocation> {

  // VV: use int as UInt storage, because in 64-bit VM, compressed references enabled
  // sizeof is 12 bytes + 4 = 16
  private /*uint*/int ID;
  /*friend  class SourceManager*/;
  /*friend  class ASTReader*/;
  /*friend  class ASTWriter*/;
  //<editor-fold defaultstate="collapsed" desc="clang::SourceLocation::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 93,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 92,
   FQN="clang::SourceLocation::(anonymous)", NM="_ZN5clang14SourceLocationE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceLocation.cpp -nm=_ZN5clang14SourceLocationE_Unnamed_enum")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS : unsigned int {*/
    private static final /*uint*/int MacroIDBit = 1/*U*/ << 31;
  /*}*/
/*public:*/
  
  //<editor-fold defaultstate="collapsed" desc="clang::SourceLocation::SourceLocation">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 98,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 97,
   FQN="clang::SourceLocation::SourceLocation", NM="_ZN5clang14SourceLocationC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZN5clang14SourceLocationC1Ev")
  //</editor-fold>
  public SourceLocation() {
    /* : ID(0)*/ 
    //START JInit
    this(0);
//    this.ID = 0;
    //END JInit
  }

  protected SourceLocation(/*uint*/int UINT_Encoding) {
    this.ID = UINT_Encoding;
    trackInstance();
  }
  
  //<editor-fold defaultstate="collapsed" desc="clang::SourceLocation::isFileID">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 100,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 99,
   FQN="clang::SourceLocation::isFileID", NM="_ZNK5clang14SourceLocation8isFileIDEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZNK5clang14SourceLocation8isFileIDEv")
  //</editor-fold>
  public boolean isFileID() /*const*/ {
    return isFileID(ID);
  }
  public static boolean isFileID(/*SourceLocation*/int rawID) /*const*/ {
    return (rawID & MacroIDBit) == 0;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SourceLocation::isMacroID">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 101,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 100,
   FQN="clang::SourceLocation::isMacroID", NM="_ZNK5clang14SourceLocation9isMacroIDEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZNK5clang14SourceLocation9isMacroIDEv")
  //</editor-fold>
  public boolean isMacroID() /*const*/ {
    return isMacroID(ID);
  }

  public static boolean isMacroID(/*SourceLocation*/int rawID) /*const*/ {
    return (rawID & MacroIDBit) != 0;
  }

  
  /// \brief Return true if this is a valid SourceLocation object.
  ///
  /// Invalid SourceLocations are often used when events have no corresponding
  /// location in the source (e.g. a diagnostic is required for a command line
  /// option).
  //<editor-fold defaultstate="collapsed" desc="clang::SourceLocation::isValid">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 108,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 107,
   FQN="clang::SourceLocation::isValid", NM="_ZNK5clang14SourceLocation7isValidEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZNK5clang14SourceLocation7isValidEv")
  //</editor-fold>
  public boolean isValid() /*const*/ {
    return ID != 0;
  }
  public static boolean isValid(/*SourceLocation*/int rawID) /*const*/ {
    return rawID != 0;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SourceLocation::isInvalid">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 109,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 108,
   FQN="clang::SourceLocation::isInvalid", NM="_ZNK5clang14SourceLocation9isInvalidEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZNK5clang14SourceLocation9isInvalidEv")
  //</editor-fold>
  public boolean isInvalid() /*const*/ {
    return ID == 0;
  }
  public static boolean isInvalid(/*SourceLocation*/int rawID) /*const*/ {
    return rawID == 0;
  }

/*private:*/
  /// \brief Return the offset into the manager's global input view.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceLocation::getOffset">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 113,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 112,
   FQN="clang::SourceLocation::getOffset", NM="_ZNK5clang14SourceLocation9getOffsetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZNK5clang14SourceLocation9getOffsetEv")
  //</editor-fold>
  /*friend*/public/*uint*/int getOffset() /*const*/ {
    return getOffset(ID);
  }
  public static /*uint*/int getOffset(/*SourceLocation*/int rawID) {
    return rawID & ~MacroIDBit;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::SourceLocation::getFileLoc">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 117,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 116,
   FQN="clang::SourceLocation::getFileLoc", NM="_ZN5clang14SourceLocation10getFileLocEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZN5clang14SourceLocation10getFileLocEj")
  //</editor-fold>
  static SourceLocation getFileLoc(/*uint*/int ID) {
    assert ((ID & MacroIDBit) == 0) : "Ran out of source locations!";
    SourceLocation L/*J*/= new SourceLocation();
    L.ID = ID;
    return L;
  }
  static /*SourceLocation*/int $getFileLoc(/*uint*/int ID) {
    assert ((ID & MacroIDBit) == 0) : "Ran out of source locations!";
    return ID;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::SourceLocation::getMacroLoc">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 124,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 123,
   FQN="clang::SourceLocation::getMacroLoc", NM="_ZN5clang14SourceLocation11getMacroLocEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZN5clang14SourceLocation11getMacroLocEj")
  //</editor-fold>
  static SourceLocation getMacroLoc(/*uint*/int ID) {
    assert ((ID & MacroIDBit) == 0) : "Ran out of source locations!";
    SourceLocation L/*J*/= new SourceLocation();
    L.ID = MacroIDBit | ID;
    return L;
  }

  static /*SourceLocation*/int $getMacroLoc(/*uint*/int ID) {
    assert ((ID & MacroIDBit) == 0) : "Ran out of source locations!";
    return MacroIDBit | ID;
  }
/*public:*/
  
  /// \brief Return a source location with the specified offset from this
  /// SourceLocation.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceLocation::getLocWithOffset">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 134,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 133,
   FQN="clang::SourceLocation::getLocWithOffset", NM="_ZNK5clang14SourceLocation16getLocWithOffsetEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZNK5clang14SourceLocation16getLocWithOffsetEi")
  //</editor-fold>
  public SourceLocation getLocWithOffset(int Offset) /*const*/ {
    // JAVA: specialization for int
    assert (((getOffset() + Offset) & MacroIDBit) == 0) : "offset overflow";
    SourceLocation L/*J*/= new SourceLocation();
    assert $long2uint($uint2long(ID) + Offset) == (ID + Offset);
    L.ID = ID + Offset;
    return L;
  }
  
  public /*SourceLocation*/int $getLocWithOffset(int Offset) /*const*/ {
    return $getLocWithOffset(ID, Offset);
  }
  public static /*SourceLocation*/int $getLocWithOffset(/*SourceLocation*/int rawID, int Offset) {
    assert (((getOffset(rawID) + Offset) & MacroIDBit) == 0) : "offset overflow";
    assert $long2uint($uint2long(rawID) + Offset) == (rawID + Offset);
    return rawID + (Offset);
  }
  
  /// \brief When a SourceLocation itself cannot be used, this returns
  /// an (opaque) 32-bit integer encoding for it.
  ///
  /// This should only be passed to SourceLocation::getFromRawEncoding, it
  /// should not be inspected directly.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceLocation::getRawEncoding">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 146,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 145,
   FQN="clang::SourceLocation::getRawEncoding", NM="_ZNK5clang14SourceLocation14getRawEncodingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZNK5clang14SourceLocation14getRawEncodingEv")
  //</editor-fold>
  public /*uint*/int getRawEncoding() /*const*/ {
    return ID;
  }

  public static /*SourceLocation*/int getInvalid() {
    return 0;
  }
  
  /// \brief Turn a raw encoding of a SourceLocation object into
  /// a real SourceLocation.
  ///
  /// \see getRawEncoding.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceLocation::getFromRawEncoding">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 152,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 151,
   FQN="clang::SourceLocation::getFromRawEncoding", NM="_ZN5clang14SourceLocation18getFromRawEncodingEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZN5clang14SourceLocation18getFromRawEncodingEj")
  //</editor-fold>
  public static SourceLocation getFromRawEncoding(/*uint*/int Encoding) {
//    SourceLocation X/*J*/= new SourceLocation();
//    X.ID = UINT_Encoding;
//    return X;
    return new SourceLocation(Encoding);
  }  
  
  
  /// \brief When a SourceLocation itself cannot be used, this returns
  /// an (opaque) pointer encoding for it.
  ///
  /// This should only be passed to SourceLocation::getFromPtrEncoding, it
  /// should not be inspected directly.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceLocation::getPtrEncoding">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 163,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 162,
   FQN="clang::SourceLocation::getPtrEncoding", NM="_ZNK5clang14SourceLocation14getPtrEncodingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZNK5clang14SourceLocation14getPtrEncodingEv")
  //</editor-fold>
  public Integer/*void P*/ getPtrEncoding() /*const*/ {
    // Double cast to avoid a warning "cast to pointer from integer of different
    // size".
    return (Integer/*uintptr_t*/)getRawEncoding();
  }

  
  /// \brief Turn a pointer encoding of a SourceLocation object back
  /// into a real SourceLocation.
  //<editor-fold defaultstate="collapsed" desc="clang::SourceLocation::getFromPtrEncoding">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 171,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 170,
   FQN="clang::SourceLocation::getFromPtrEncoding", NM="_ZN5clang14SourceLocation18getFromPtrEncodingEPKv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZN5clang14SourceLocation18getFromPtrEncodingEPKv")
  //</editor-fold>
  public static SourceLocation getFromPtrEncoding(/*const*/Object/*void P*/ Encoding) {
    return getFromRawEncoding((Integer)Encoding);
  }

  
  //===----------------------------------------------------------------------===//
  // SourceLocation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::SourceLocation::print">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceLocation.cpp", line = 38,
   FQN="clang::SourceLocation::print", NM="_ZNK5clang14SourceLocation5printERN4llvm11raw_ostreamERKNS_13SourceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceLocation.cpp -nm=_ZNK5clang14SourceLocation5printERN4llvm11raw_ostreamERKNS_13SourceManagerE")
  //</editor-fold>
  public void print(raw_ostream /*&*/ OS, /*const*/ SourceManager /*&*/ SM) /*const*/ {
    if (!isValid()) {
      OS.$out(/*KEEP_STR*/"<invalid loc>");
      return;
    }
    if (isFileID()) {
      PresumedLoc PLoc = SM.getPresumedLoc(/*NO_COPY*//*Deref*/this);
      if (PLoc.isInvalid()) {
        OS.$out(/*KEEP_STR*/$invalid_marker);
        return;
      }
      // The macro expansion and spelling pos is identical for file locs.
      OS.$out(PLoc.getFilename()).$out_char($$COLON).$out_uint(PLoc.getLine()).$out_char($$COLON).$out_uint(PLoc.getColumn());
      return;
    }

    SM.getExpansionLoc(/*NO_COPY*//*Deref*/this).print(OS, SM);
    
    OS.$out(/*KEEP_STR*/" <Spelling=");
    SM.getSpellingLoc(/*NO_COPY*//*Deref*/this).print(OS, SM);
    OS.$out_char($$GT);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::SourceLocation::printToString">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceLocation.cpp", line = 64,
   FQN="clang::SourceLocation::printToString", NM="_ZNK5clang14SourceLocation13printToStringERKNS_13SourceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceLocation.cpp -nm=_ZNK5clang14SourceLocation13printToStringERKNS_13SourceManagerE")
  //</editor-fold>
  public std.string printToString(/*const*/ SourceManager /*&*/ SM) /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    raw_string_ostream OS = null;
    try {
      std.string S/*J*/= new std.string();
      OS/*J*/= new raw_string_ostream(S);
      print(OS, SM);
      return OS.str();
    } finally {
      if (OS != null) { OS.$destroy(); }
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::SourceLocation::dump">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceLocation.cpp", line = 72,
   FQN="clang::SourceLocation::dump", NM="_ZNK5clang14SourceLocation4dumpERKNS_13SourceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceLocation.cpp -nm=_ZNK5clang14SourceLocation4dumpERKNS_13SourceManagerE")
  //</editor-fold>
  public void dump(/*const*/ SourceManager /*&*/ SM) /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    print(llvm.errs(), SM);
  }
  public void dump(/*const*/SourceManager /*&*/ SM, raw_ostream /*&*/ OS) /*const*/ {
    print(OS, SM);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::SourceLocation::SourceLocation">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 88,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 87,
   FQN="clang::SourceLocation::SourceLocation", NM="_ZN5clang14SourceLocationC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZN5clang14SourceLocationC1ERKS0_")
  //</editor-fold>
  public /*inline*/ SourceLocation(/*const*/ SourceLocation /*&*/ $Prm0) {
    /* : ID(.ID)*/ 
    //START JInit
//    this.ID = $Prm0.ID;
    this($Prm0.ID);
    //END JInit
  }
  
  //<editor-fold defaultstate="collapsed" desc="clang::SourceLocation::SourceLocation">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 88,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 87,
   FQN="clang::SourceLocation::SourceLocation", NM="_ZN5clang14SourceLocationC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZN5clang14SourceLocationC1EOS0_")
  //</editor-fold>
  public /*inline*/ SourceLocation(JD$Move _dparam, SourceLocation /*&&*/$Prm0) {
    /* : ID(static_cast<SourceLocation &&>().ID)*/ 
    //START JInit
    this.ID = $Prm0.ID;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SourceLocation::operator=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 88,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 87,
   FQN="clang::SourceLocation::operator=", NM="_ZN5clang14SourceLocationaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZN5clang14SourceLocationaSERKS0_")
  //</editor-fold>
  public /*inline*/ SourceLocation /*&*/ $assign(/*const*/ SourceLocation /*&*/ $Prm0) {
    this.ID = $Prm0.ID;
    return /*Deref*/this;
  }
  public /*inline*/ SourceLocation /*&*/ $assign(/*SourceLocation*/int $Prm0)/* throw()*/ {
    this.ID = $Prm0;
    return /*Deref*/this;
  }
  
  //<editor-fold defaultstate="collapsed" desc="clang::SourceLocation::operator=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 88,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 87,
   FQN="clang::SourceLocation::operator=", NM="_ZN5clang14SourceLocationaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp -nm=_ZN5clang14SourceLocationaSEOS0_")
  //</editor-fold>
  public /*inline*/ SourceLocation /*&*/ $assignMove(SourceLocation /*&&*/$Prm0) {
    this.ID = $Prm0.ID;
    $Prm0.ID = 0;
    return /*Deref*/this;
  }
  public /*inline*/ SourceLocation /*&*/ $assignMove(int /*&&*/$Prm0) {
    this.ID = $Prm0;
    return /*Deref*/this;
  }

  @Override
  public String toString() {
    return toString(ID);
  } 

  public static String toString(/*SourceLocation*/int Loc) {
    if (isInvalid(Loc)) {
      return "INVALID";
    }
    return (isMacroID(Loc) ? "[M:":"[F:") + getOffset(Loc) + "]";
  }
  
  @Override
  public SourceLocation clone() {
    return new SourceLocation(this);
  }
  
  @Override
  public SourceLocation move() {
    return new SourceLocation(JD$Move.INSTANCE, this);
  }

  @Override
  public boolean $noteq(SourceLocation other) {
    return BasicClangGlobals.$noteq_SourceLocation$C(this, other);
   }

  @Override
  public boolean $eq(SourceLocation other) {
    return BasicClangGlobals.$eq_SourceLocation$C(this, other);
  }

  @Override
  public int $sizeof() {
    return $sizeof_SourceLocation();
  }
  
  public static int $sizeof_SourceLocation() {
    return NativeType.BYTES_IN_JAVA_OBJECT_HEADER +
           NativeType.BYTES_IN_INT;
  }
  
  //////////////////////////////////////////////////////////////////////////////
  // Performance Statistics
  private static long instances = 0;
  private static void trackInstance() {
    if (NativeTrace.STATISTICS) instances++;
  }
  
  public static void clearStatistics() {
    instances = 0;
  }
  // JAVA: pass OS and return some integral value
  public static long PrintStats(raw_ostream out) {
    out.$out(String.format("%22s created:\t", SourceLocation.class.getSimpleName())).$out(NativeTrace.formatNumber(instances)).$out(".\n");
    NativeTrace.dumpStatisticValue(SourceLocation.class.getSimpleName(), instances);
    return instances;
  }  

  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  @Override public void swap(NativeSwappable RHS) {
    SourceLocation other = (SourceLocation) RHS;
    int tmp = this.ID;
    this.ID = other.ID;
    other.ID = tmp;
  }
  
  public static final SourceLocation DEFAULT = new SourceLocation();
  
  public static final Comparator<SourceLocation> COMPARATOR = new Comparator<SourceLocation>() {
    @Override
    public int compare(SourceLocation lhs, SourceLocation rhs) {
      return $compare_uint(lhs.ID, rhs.ID);
    }
  };
  
}
