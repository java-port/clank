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

package org.clang.staticanalyzer.core.pathsensitive.ento;

import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.staticanalyzer.core.pathsensitive.llvm.StaticanalyzerLlvmGlobals.*;


/// SymbolMetadata - Represents path-dependent metadata about a specific region.
///  Metadata symbols remain live as long as they are marked as in use before
///  dead-symbol sweeping AND their associated regions are still alive.
///  Intended for use by checkers.
//<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolMetadata">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SymbolManager.h", line = 185,
 FQN="clang::ento::SymbolMetadata", NM="_ZN5clang4ento14SymbolMetadataE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZN5clang4ento14SymbolMetadataE")
//</editor-fold>
public class SymbolMetadata extends /*public*/ SymbolData implements Destructors.ClassWithDestructor {
  private /*const*/ MemRegion /*P*/ R;
  private /*const*/ Stmt /*P*/ S;
  private QualType T;
  private /*uint*/int Count;
  private /*const*/Object/*void P*/ Tag;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolMetadata::SymbolMetadata">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SymbolManager.h", line = 192,
   FQN="clang::ento::SymbolMetadata::SymbolMetadata", NM="_ZN5clang4ento14SymbolMetadataC1EjPKNS0_9MemRegionEPKNS_4StmtENS_8QualTypeEjPKv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZN5clang4ento14SymbolMetadataC1EjPKNS0_9MemRegionEPKNS_4StmtENS_8QualTypeEjPKv")
  //</editor-fold>
  public SymbolMetadata(/*uint*/int sym, /*const*/ MemRegion /*P*/ r, /*const*/ Stmt /*P*/ s, QualType t, 
      /*uint*/int count, /*const*/Object/*void P*/ tag) {
    // : SymbolData(SymbolMetadataKind, sym), R(r), S(s), T(t), Count(count), Tag(tag) 
    //START JInit
    super(Kind.SymbolMetadataKind, sym);
    this.R = r;
    this.S = s;
    this.T = new QualType(t);
    this.Count = count;
    this.Tag = tag;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolMetadata::getRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SymbolManager.h", line = 196,
   FQN="clang::ento::SymbolMetadata::getRegion", NM="_ZNK5clang4ento14SymbolMetadata9getRegionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZNK5clang4ento14SymbolMetadata9getRegionEv")
  //</editor-fold>
  public /*const*/ MemRegion /*P*/ getRegion() /*const*/ {
    return R;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolMetadata::getStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SymbolManager.h", line = 197,
   FQN="clang::ento::SymbolMetadata::getStmt", NM="_ZNK5clang4ento14SymbolMetadata7getStmtEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZNK5clang4ento14SymbolMetadata7getStmtEv")
  //</editor-fold>
  public /*const*/ Stmt /*P*/ getStmt() /*const*/ {
    return S;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolMetadata::getCount">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SymbolManager.h", line = 198,
   FQN="clang::ento::SymbolMetadata::getCount", NM="_ZNK5clang4ento14SymbolMetadata8getCountEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZNK5clang4ento14SymbolMetadata8getCountEv")
  //</editor-fold>
  public /*uint*/int getCount() /*const*/ {
    return Count;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolMetadata::getTag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SymbolManager.h", line = 199,
   FQN="clang::ento::SymbolMetadata::getTag", NM="_ZNK5clang4ento14SymbolMetadata6getTagEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZNK5clang4ento14SymbolMetadata6getTagEv")
  //</editor-fold>
  public /*const*/Object/*void P*/ getTag() /*const*/ {
    return Tag;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolMetadata::getType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp", line = 320,
   FQN="clang::ento::SymbolMetadata::getType", NM="_ZNK5clang4ento14SymbolMetadata7getTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZNK5clang4ento14SymbolMetadata7getTypeEv")
  //</editor-fold>
  @Override public QualType getType() /*const*//* override*/ {
    return new QualType(T);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolMetadata::dumpToStream">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp", line = 80,
   FQN="clang::ento::SymbolMetadata::dumpToStream", NM="_ZNK5clang4ento14SymbolMetadata12dumpToStreamERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZNK5clang4ento14SymbolMetadata12dumpToStreamERN4llvm11raw_ostreamE")
  //</editor-fold>
  @Override public void dumpToStream(final raw_ostream /*&*/ os) /*const*//* override*/ {
    $out_raw_ostream_MemRegion$C$P(os.$out(/*KEEP_STR*/"meta_$").$out_uint(getSymbolID()).$out_char($$LCURLY), 
        getRegion()).$out_char($$COMMA).$out(T.getAsString()).$out_char($$RCURLY);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolMetadata::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SymbolManager.h", line = 205,
   FQN="clang::ento::SymbolMetadata::Profile", NM="_ZN5clang4ento14SymbolMetadata7ProfileERN4llvm16FoldingSetNodeIDEPKNS0_9MemRegionEPKNS_4StmtENS_8QualTypeEjPKv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZN5clang4ento14SymbolMetadata7ProfileERN4llvm16FoldingSetNodeIDEPKNS0_9MemRegionEPKNS_4StmtENS_8QualTypeEjPKv")
  //</editor-fold>
  public static void Profile(final FoldingSetNodeID /*&*/ profile, /*const*/ MemRegion /*P*/ R, 
         /*const*/ Stmt /*P*/ S, QualType T, /*uint*/int Count, 
         /*const*/Object/*void P*/ Tag) {
    profile.AddInteger_uint((/*uint*/int)Kind.SymbolMetadataKind.getValue());
    profile.AddPointer(R);
    profile.AddPointer(S);
    profile.Add(T);
    profile.AddInteger_uint(Count);
    profile.AddPointer(Tag);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolMetadata::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SymbolManager.h", line = 216,
   FQN="clang::ento::SymbolMetadata::Profile", NM="_ZN5clang4ento14SymbolMetadata7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZN5clang4ento14SymbolMetadata7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  @Override public void Profile(final FoldingSetNodeID /*&*/ profile)/* override*/ {
    Profile(profile, R, S, /*NO_COPY*/T, Count, Tag);
  }

  
  // Implement isa<T> support.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolMetadata::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SymbolManager.h", line = 221,
   FQN="clang::ento::SymbolMetadata::classof", NM="_ZN5clang4ento14SymbolMetadata7classofEPKNS0_7SymExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZN5clang4ento14SymbolMetadata7classofEPKNS0_7SymExprE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ SymExpr /*P*/ SE) {
    return SE.getKind() == Kind.SymbolMetadataKind;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolMetadata::~SymbolMetadata">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SymbolManager.h", line = 185,
   FQN="clang::ento::SymbolMetadata::~SymbolMetadata", NM="_ZN5clang4ento14SymbolMetadataD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZN5clang4ento14SymbolMetadataD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "R=" + R // NOI18N
              + ", S=" + S // NOI18N
              + ", T=" + T // NOI18N
              + ", Count=" + Count // NOI18N
              + ", Tag=" + Tag // NOI18N
              + super.toString(); // NOI18N
  }
}
