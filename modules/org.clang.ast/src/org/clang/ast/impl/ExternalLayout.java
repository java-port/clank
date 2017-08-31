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

package org.clang.ast.impl;

import org.clank.support.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;


/// \brief Externally provided layout. Typically used when the AST source, such
/// as DWARF, lacks all the information that was available at compile time, such
/// as alignment attributes on fields and pragmas in effect.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ExternalLayout">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 60,
 FQN="(anonymous namespace)::ExternalLayout", NM="_ZN12_GLOBAL__N_114ExternalLayoutE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_114ExternalLayoutE")
//</editor-fold>
public class/*struct*/ ExternalLayout implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ExternalLayout::ExternalLayout">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 61,
   FQN="(anonymous namespace)::ExternalLayout::ExternalLayout", NM="_ZN12_GLOBAL__N_114ExternalLayoutC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_114ExternalLayoutC1Ev")
  //</editor-fold>
  public ExternalLayout() {
    // : Size(0), Align(0), FieldOffsets(), BaseOffsets(), VirtualBaseOffsets() 
    //START JInit
    this.Size = $int2ulong(0);
    this.Align = $int2ulong(0);
    this.FieldOffsets = new DenseMapTypeULong</*const*/ FieldDecl /*P*/>(DenseMapInfo$LikePtr.$Info(), 0l);
    this.BaseOffsets = new DenseMap</*const*/ CXXRecordDecl /*P*/ , CharUnits>(DenseMapInfo$LikePtr.$Info(), new CharUnits());
    this.VirtualBaseOffsets = new DenseMap</*const*/ CXXRecordDecl /*P*/ , CharUnits>(DenseMapInfo$LikePtr.$Info(), new CharUnits());
    //END JInit
  }

  
  /// \brief Overall record size in bits.
  public long/*uint64_t*/ Size;
  
  /// \brief Overall record alignment in bits.
  public long/*uint64_t*/ Align;
  
  /// \brief Record field offsets in bits.
  public DenseMapTypeULong</*const*/ FieldDecl /*P*/> FieldOffsets;
  
  /// \brief Direct, non-virtual base offsets.
  public DenseMap</*const*/ CXXRecordDecl /*P*/ , CharUnits> BaseOffsets;
  
  /// \brief Virtual base offsets.
  public DenseMap</*const*/ CXXRecordDecl /*P*/ , CharUnits> VirtualBaseOffsets;
  
  /// Get the offset of the given field. The external source must provide
  /// entries for all fields in the record.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ExternalLayout::getExternalFieldOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 80,
   FQN="(anonymous namespace)::ExternalLayout::getExternalFieldOffset", NM="_ZN12_GLOBAL__N_114ExternalLayout22getExternalFieldOffsetEPKN5clang9FieldDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_114ExternalLayout22getExternalFieldOffsetEPKN5clang9FieldDeclE")
  //</editor-fold>
  public long/*uint64_t*/ getExternalFieldOffset(/*const*/ FieldDecl /*P*/ FD) {
    assert ((FieldOffsets.count(FD) != 0)) : "Field does not have an external offset";
    return FieldOffsets.$at_T1$C$R(FD);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ExternalLayout::getExternalNVBaseOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 86,
   FQN="(anonymous namespace)::ExternalLayout::getExternalNVBaseOffset", NM="_ZN12_GLOBAL__N_114ExternalLayout23getExternalNVBaseOffsetEPKN5clang13CXXRecordDeclERNS1_9CharUnitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_114ExternalLayout23getExternalNVBaseOffsetEPKN5clang13CXXRecordDeclERNS1_9CharUnitsE")
  //</editor-fold>
  public boolean getExternalNVBaseOffset(/*const*/ CXXRecordDecl /*P*/ RD, final CharUnits /*&*/ BaseOffset) {
    DenseMapIterator</*const*/ CXXRecordDecl /*P*/ , CharUnits> Known = BaseOffsets.find(RD);
    if (Known.$eq(/*NO_ITER_COPY*/BaseOffsets.end())) {
      return false;
    }
    BaseOffset.$assign(Known.$arrow().second);
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ExternalLayout::getExternalVBaseOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 94,
   FQN="(anonymous namespace)::ExternalLayout::getExternalVBaseOffset", NM="_ZN12_GLOBAL__N_114ExternalLayout22getExternalVBaseOffsetEPKN5clang13CXXRecordDeclERNS1_9CharUnitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_114ExternalLayout22getExternalVBaseOffsetEPKN5clang13CXXRecordDeclERNS1_9CharUnitsE")
  //</editor-fold>
  public boolean getExternalVBaseOffset(/*const*/ CXXRecordDecl /*P*/ RD, final CharUnits /*&*/ BaseOffset) {
    DenseMapIterator</*const*/ CXXRecordDecl /*P*/ , CharUnits> Known = VirtualBaseOffsets.find(RD);
    if (Known.$eq(/*NO_ITER_COPY*/VirtualBaseOffsets.end())) {
      return false;
    }
    BaseOffset.$assign(Known.$arrow().second);
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ExternalLayout::~ExternalLayout">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 60,
   FQN="(anonymous namespace)::ExternalLayout::~ExternalLayout", NM="_ZN12_GLOBAL__N_114ExternalLayoutD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_114ExternalLayoutD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    VirtualBaseOffsets.$destroy();
    BaseOffsets.$destroy();
    FieldOffsets.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Size=" + Size // NOI18N
              + ", Align=" + Align // NOI18N
              + ", FieldOffsets=" + FieldOffsets // NOI18N
              + ", BaseOffsets=" + BaseOffsets // NOI18N
              + ", VirtualBaseOffsets=" + VirtualBaseOffsets; // NOI18N
  }
}
