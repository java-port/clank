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

package org.llvm.debuginfo.codeview;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;


/// A 32-bit type reference. Types are indexed by their order of appearance in
/// .debug$T plus 0x1000. Type indices less than 0x1000 are "simple" types,
/// composed of a SimpleTypeMode byte followed by a SimpleTypeKind byte.
//<editor-fold defaultstate="collapsed" desc="llvm::codeview::TypeIndex">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/TypeIndex.h", line = 89,
 FQN="llvm::codeview::TypeIndex", NM="_ZN4llvm8codeview9TypeIndexE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview9TypeIndexE")
//</editor-fold>
public class TypeIndex {
/*public:*/
  public static /*const*//*uint32_t*/int FirstNonSimpleIndex = 0x1000;
  public static /*const*//*uint32_t*/int SimpleKindMask = 0x000000ff;
  public static /*const*//*uint32_t*/int SimpleModeMask = 0x00000700;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::TypeIndex::TypeIndex">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/TypeIndex.h", line = 96,
   FQN="llvm::codeview::TypeIndex::TypeIndex", NM="_ZN4llvm8codeview9TypeIndexC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview9TypeIndexC1Ev")
  //</editor-fold>
  public TypeIndex() {
    // : Index(0) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::TypeIndex::TypeIndex">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/TypeIndex.h", line = 97,
   FQN="llvm::codeview::TypeIndex::TypeIndex", NM="_ZN4llvm8codeview9TypeIndexC1Ej",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview9TypeIndexC1Ej")
  //</editor-fold>
  public /*explicit*/ TypeIndex(/*uint32_t*/int Index) {
    // : Index(Index) 
    throw new UnsupportedOperationException("EmptyBody");
  }

//  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::TypeIndex::TypeIndex">
//  @Converted(kind = Converted.Kind.DELETED,
//   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/TypeIndex.h", line = 98,
//   FQN="llvm::codeview::TypeIndex::TypeIndex", NM="_ZN4llvm8codeview9TypeIndexC1ENS0_14SimpleTypeKindE",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview9TypeIndexC1ENS0_14SimpleTypeKindE")
//  //</editor-fold>
//  public /*explicit*/ TypeIndex(/*SimpleTypeKind*//*uint32_t*/int Kind) {
//    // : Index(static_cast<uint32_t>(Kind)) 
//    throw new UnsupportedOperationException("EmptyBody");
//  }

  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::TypeIndex::TypeIndex">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/TypeIndex.h", line = 100,
   FQN="llvm::codeview::TypeIndex::TypeIndex", NM="_ZN4llvm8codeview9TypeIndexC1ENS0_14SimpleTypeKindENS0_14SimpleTypeModeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview9TypeIndexC1ENS0_14SimpleTypeKindENS0_14SimpleTypeModeE")
  //</editor-fold>
  public TypeIndex(/*SimpleTypeKind*//*uint32_t*/int Kind, /*SimpleTypeMode*//*uint32_t*/int Mode) {
    // : Index(static_cast<uint32_t>(Kind) | static_cast<uint32_t>(Mode)) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::TypeIndex::getIndex">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/TypeIndex.h", line = 103,
   FQN="llvm::codeview::TypeIndex::getIndex", NM="_ZNK4llvm8codeview9TypeIndex8getIndexEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZNK4llvm8codeview9TypeIndex8getIndexEv")
  //</editor-fold>
  public /*uint32_t*/int getIndex() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::TypeIndex::isSimple">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/TypeIndex.h", line = 104,
   FQN="llvm::codeview::TypeIndex::isSimple", NM="_ZNK4llvm8codeview9TypeIndex8isSimpleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZNK4llvm8codeview9TypeIndex8isSimpleEv")
  //</editor-fold>
  public boolean isSimple() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::TypeIndex::isNoneType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/TypeIndex.h", line = 106,
   FQN="llvm::codeview::TypeIndex::isNoneType", NM="_ZNK4llvm8codeview9TypeIndex10isNoneTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZNK4llvm8codeview9TypeIndex10isNoneTypeEv")
  //</editor-fold>
  public boolean isNoneType() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::TypeIndex::getSimpleKind">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/TypeIndex.h", line = 108,
   FQN="llvm::codeview::TypeIndex::getSimpleKind", NM="_ZNK4llvm8codeview9TypeIndex13getSimpleKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZNK4llvm8codeview9TypeIndex13getSimpleKindEv")
  //</editor-fold>
  public /*SimpleTypeKind*//*uint32_t*/int getSimpleKind() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::TypeIndex::getSimpleMode">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/TypeIndex.h", line = 113,
   FQN="llvm::codeview::TypeIndex::getSimpleMode", NM="_ZNK4llvm8codeview9TypeIndex13getSimpleModeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZNK4llvm8codeview9TypeIndex13getSimpleModeEv")
  //</editor-fold>
  public /*SimpleTypeMode*//*uint32_t*/int getSimpleMode() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::TypeIndex::None">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/TypeIndex.h", line = 118,
   FQN="llvm::codeview::TypeIndex::None", NM="_ZN4llvm8codeview9TypeIndex4NoneEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview9TypeIndex4NoneEv")
  //</editor-fold>
  public static TypeIndex None() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::TypeIndex::Void">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/TypeIndex.h", line = 119,
   FQN="llvm::codeview::TypeIndex::Void", NM="_ZN4llvm8codeview9TypeIndex4VoidEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview9TypeIndex4VoidEv")
  //</editor-fold>
  public static TypeIndex Void() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::TypeIndex::VoidPointer32">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/TypeIndex.h", line = 120,
   FQN="llvm::codeview::TypeIndex::VoidPointer32", NM="_ZN4llvm8codeview9TypeIndex13VoidPointer32Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview9TypeIndex13VoidPointer32Ev")
  //</editor-fold>
  public static TypeIndex VoidPointer32() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::TypeIndex::VoidPointer64">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/TypeIndex.h", line = 123,
   FQN="llvm::codeview::TypeIndex::VoidPointer64", NM="_ZN4llvm8codeview9TypeIndex13VoidPointer64Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview9TypeIndex13VoidPointer64Ev")
  //</editor-fold>
  public static TypeIndex VoidPointer64() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::TypeIndex::SignedCharacter">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/TypeIndex.h", line = 127,
   FQN="llvm::codeview::TypeIndex::SignedCharacter", NM="_ZN4llvm8codeview9TypeIndex15SignedCharacterEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview9TypeIndex15SignedCharacterEv")
  //</editor-fold>
  public static TypeIndex SignedCharacter() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::TypeIndex::UnsignedCharacter">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/TypeIndex.h", line = 130,
   FQN="llvm::codeview::TypeIndex::UnsignedCharacter", NM="_ZN4llvm8codeview9TypeIndex17UnsignedCharacterEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview9TypeIndex17UnsignedCharacterEv")
  //</editor-fold>
  public static TypeIndex UnsignedCharacter() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::TypeIndex::NarrowCharacter">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/TypeIndex.h", line = 133,
   FQN="llvm::codeview::TypeIndex::NarrowCharacter", NM="_ZN4llvm8codeview9TypeIndex15NarrowCharacterEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview9TypeIndex15NarrowCharacterEv")
  //</editor-fold>
  public static TypeIndex NarrowCharacter() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::TypeIndex::WideCharacter">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/TypeIndex.h", line = 136,
   FQN="llvm::codeview::TypeIndex::WideCharacter", NM="_ZN4llvm8codeview9TypeIndex13WideCharacterEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview9TypeIndex13WideCharacterEv")
  //</editor-fold>
  public static TypeIndex WideCharacter() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::TypeIndex::Int16Short">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/TypeIndex.h", line = 139,
   FQN="llvm::codeview::TypeIndex::Int16Short", NM="_ZN4llvm8codeview9TypeIndex10Int16ShortEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview9TypeIndex10Int16ShortEv")
  //</editor-fold>
  public static TypeIndex Int16Short() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::TypeIndex::UInt16Short">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/TypeIndex.h", line = 142,
   FQN="llvm::codeview::TypeIndex::UInt16Short", NM="_ZN4llvm8codeview9TypeIndex11UInt16ShortEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview9TypeIndex11UInt16ShortEv")
  //</editor-fold>
  public static TypeIndex UInt16Short() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::TypeIndex::Int32">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/TypeIndex.h", line = 145,
   FQN="llvm::codeview::TypeIndex::Int32", NM="_ZN4llvm8codeview9TypeIndex5Int32Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview9TypeIndex5Int32Ev")
  //</editor-fold>
  public static TypeIndex Int32() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::TypeIndex::UInt32">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/TypeIndex.h", line = 146,
   FQN="llvm::codeview::TypeIndex::UInt32", NM="_ZN4llvm8codeview9TypeIndex6UInt32Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview9TypeIndex6UInt32Ev")
  //</editor-fold>
  public static TypeIndex UInt32() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::TypeIndex::Int32Long">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/TypeIndex.h", line = 147,
   FQN="llvm::codeview::TypeIndex::Int32Long", NM="_ZN4llvm8codeview9TypeIndex9Int32LongEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview9TypeIndex9Int32LongEv")
  //</editor-fold>
  public static TypeIndex Int32Long() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::TypeIndex::UInt32Long">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/TypeIndex.h", line = 148,
   FQN="llvm::codeview::TypeIndex::UInt32Long", NM="_ZN4llvm8codeview9TypeIndex10UInt32LongEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview9TypeIndex10UInt32LongEv")
  //</editor-fold>
  public static TypeIndex UInt32Long() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::TypeIndex::Int64">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/TypeIndex.h", line = 151,
   FQN="llvm::codeview::TypeIndex::Int64", NM="_ZN4llvm8codeview9TypeIndex5Int64Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview9TypeIndex5Int64Ev")
  //</editor-fold>
  public static TypeIndex Int64() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::TypeIndex::UInt64">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/TypeIndex.h", line = 152,
   FQN="llvm::codeview::TypeIndex::UInt64", NM="_ZN4llvm8codeview9TypeIndex6UInt64Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview9TypeIndex6UInt64Ev")
  //</editor-fold>
  public static TypeIndex UInt64() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::TypeIndex::Int64Quad">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/TypeIndex.h", line = 153,
   FQN="llvm::codeview::TypeIndex::Int64Quad", NM="_ZN4llvm8codeview9TypeIndex9Int64QuadEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview9TypeIndex9Int64QuadEv")
  //</editor-fold>
  public static TypeIndex Int64Quad() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::TypeIndex::UInt64Quad">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/TypeIndex.h", line = 154,
   FQN="llvm::codeview::TypeIndex::UInt64Quad", NM="_ZN4llvm8codeview9TypeIndex10UInt64QuadEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview9TypeIndex10UInt64QuadEv")
  //</editor-fold>
  public static TypeIndex UInt64Quad() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::TypeIndex::Float32">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/TypeIndex.h", line = 158,
   FQN="llvm::codeview::TypeIndex::Float32", NM="_ZN4llvm8codeview9TypeIndex7Float32Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview9TypeIndex7Float32Ev")
  //</editor-fold>
  public static TypeIndex Float32() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::TypeIndex::Float64">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/TypeIndex.h", line = 159,
   FQN="llvm::codeview::TypeIndex::Float64", NM="_ZN4llvm8codeview9TypeIndex7Float64Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview9TypeIndex7Float64Ev")
  //</editor-fold>
  public static TypeIndex Float64() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /*friend*///<editor-fold defaultstate="collapsed" desc="llvm::codeview::operator==">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/TypeIndex.h", line = 161,
   FQN="llvm::codeview::operator==", NM="_ZN4llvm8codevieweqERKNS0_9TypeIndexES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codevieweqERKNS0_9TypeIndexES3_")
  //</editor-fold>
  public static /*inline*/ boolean $eq_TypeIndex$C(final /*const*/ TypeIndex /*&*/ A, final /*const*/ TypeIndex /*&*/ B) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /*friend*///<editor-fold defaultstate="collapsed" desc="llvm::codeview::operator!=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/TypeIndex.h", line = 165,
   FQN="llvm::codeview::operator!=", NM="_ZN4llvm8codeviewneERKNS0_9TypeIndexES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeviewneERKNS0_9TypeIndexES3_")
  //</editor-fold>
  public static /*inline*/ boolean $noteq_TypeIndex$C(final /*const*/ TypeIndex /*&*/ A, final /*const*/ TypeIndex /*&*/ B) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /*friend*///<editor-fold defaultstate="collapsed" desc="llvm::codeview::operator<">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/TypeIndex.h", line = 169,
   FQN="llvm::codeview::operator<", NM="_ZN4llvm8codeviewltERKNS0_9TypeIndexES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeviewltERKNS0_9TypeIndexES3_")
  //</editor-fold>
  public static /*inline*/ boolean $less_TypeIndex$C(final /*const*/ TypeIndex /*&*/ A, final /*const*/ TypeIndex /*&*/ B) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /*friend*///<editor-fold defaultstate="collapsed" desc="llvm::codeview::operator<=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/TypeIndex.h", line = 173,
   FQN="llvm::codeview::operator<=", NM="_ZN4llvm8codeviewleERKNS0_9TypeIndexES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeviewleERKNS0_9TypeIndexES3_")
  //</editor-fold>
  public static /*inline*/ boolean $lesseq_TypeIndex$C(final /*const*/ TypeIndex /*&*/ A, final /*const*/ TypeIndex /*&*/ B) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /*friend*///<editor-fold defaultstate="collapsed" desc="llvm::codeview::operator>">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/TypeIndex.h", line = 177,
   FQN="llvm::codeview::operator>", NM="_ZN4llvm8codeviewgtERKNS0_9TypeIndexES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeviewgtERKNS0_9TypeIndexES3_")
  //</editor-fold>
  public static /*inline*/ boolean $greater_TypeIndex$C(final /*const*/ TypeIndex /*&*/ A, final /*const*/ TypeIndex /*&*/ B) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /*friend*///<editor-fold defaultstate="collapsed" desc="llvm::codeview::operator>=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/TypeIndex.h", line = 181,
   FQN="llvm::codeview::operator>=", NM="_ZN4llvm8codeviewgeERKNS0_9TypeIndexES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeviewgeERKNS0_9TypeIndexES3_")
  //</editor-fold>
  public static /*inline*/ boolean $greatereq_TypeIndex$C(final /*const*/ TypeIndex /*&*/ A, final /*const*/ TypeIndex /*&*/ B) {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  private llvm.support.ulittle32_t Index;
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::TypeIndex::TypeIndex">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/TypeIndex.h", line = 89,
   FQN="llvm::codeview::TypeIndex::TypeIndex", NM="_ZN4llvm8codeview9TypeIndexC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview9TypeIndexC1ERKS1_")
  //</editor-fold>
  public /*inline*/ TypeIndex(final /*const*/ TypeIndex /*&*/ $Prm0) {
    // : Index(.Index) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::TypeIndex::TypeIndex">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/TypeIndex.h", line = 89,
   FQN="llvm::codeview::TypeIndex::TypeIndex", NM="_ZN4llvm8codeview9TypeIndexC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview9TypeIndexC1EOS1_")
  //</editor-fold>
  public /*inline*/ TypeIndex(JD$Move _dparam, final TypeIndex /*&&*/$Prm0) {
    // : Index(static_cast<TypeIndex &&>().Index) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "Index=" + Index; // NOI18N
  }
}
