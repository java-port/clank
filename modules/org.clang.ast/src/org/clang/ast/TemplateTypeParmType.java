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

package org.clang.ast;

import org.clank.support.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.clang.basic.*;

//<editor-fold defaultstate="collapsed" desc="clang::TemplateTypeParmType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3903,
 FQN="clang::TemplateTypeParmType", NM="_ZN5clang20TemplateTypeParmTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang20TemplateTypeParmTypeE")
//</editor-fold>
public class TemplateTypeParmType extends /*public*/ Type implements /*public*/ FoldingSetImpl.Node {
  // Helper data collector for canonical types.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateTypeParmType::CanonicalTTPTInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3905,
   FQN="clang::TemplateTypeParmType::CanonicalTTPTInfo", NM="_ZN5clang20TemplateTypeParmType17CanonicalTTPTInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang20TemplateTypeParmType17CanonicalTTPTInfoE")
  //</editor-fold>
  private static class/*struct*/ CanonicalTTPTInfo {
    public /*JCHAR unsigned int*/ char Depth /*: 15*/;
    public /*JBIT unsigned int*/ boolean ParameterPack /*: 1*/;
    public /*JCHAR unsigned int*/ char Index /*: 16*/;
    
    @Override public String toString() {
      return "" + "Depth=" + $ushort2uint(Depth) // NOI18N
                + ", ParameterPack=" + ParameterPack // NOI18N
                + ", Index=" + $ushort2uint(Index); // NOI18N
    }
  };
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateTypeParmType::(anonymous)">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*init field*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3911,
   FQN="clang::TemplateTypeParmType::(anonymous)", NM="_ZN5clang20TemplateTypeParmTypeE_Unnamed_union2",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang20TemplateTypeParmTypeE_Unnamed_union2")
  //</editor-fold>
  private static class/*union*/ Unnamed_union2 {
    // Info for the canonical type.
    public final CanonicalTTPTInfo CanTTPTInfo = new CanonicalTTPTInfo();
    // Info for the non-canonical type.
    public TemplateTypeParmDecl /*P*/ TTPDecl;
    
    @Override public String toString() {
      return "" + "CanTTPTInfo=" + CanTTPTInfo // NOI18N
                + ", TTPDecl=" + TTPDecl; // NOI18N
    }
  };
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC)
  private final Unnamed_union2 Unnamed_field = new Unnamed_union2();
  
  /// Build a non-canonical type.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateTypeParmType::TemplateTypeParmType">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3919,
   FQN="clang::TemplateTypeParmType::TemplateTypeParmType", NM="_ZN5clang20TemplateTypeParmTypeC1EPNS_20TemplateTypeParmDeclENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang20TemplateTypeParmTypeC1EPNS_20TemplateTypeParmDeclENS_8QualTypeE")
  //</editor-fold>
  /*friend*//*package*/ TemplateTypeParmType(TemplateTypeParmDecl /*P*/ TTPDecl, QualType Canon) {
    // : Type(TemplateTypeParm, Canon, /*Dependent=*/ true, /*InstantiationDependent=*/ true, /*VariablyModified=*/ false, Canon->containsUnexpandedParameterPack()), FoldingSetNode(), TTPDecl(TTPDecl) 
    //START JInit
    super(TypeClass.TemplateTypeParm, new QualType(Canon), true, 
        true, 
        false, 
        Canon.$arrow().containsUnexpandedParameterPack());
    $Node();
    /*Indirect*/this.Unnamed_field.TTPDecl = TTPDecl;
    //END JInit
  }

  
  /// Build the canonical type.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateTypeParmType::TemplateTypeParmType">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3927,
   FQN="clang::TemplateTypeParmType::TemplateTypeParmType", NM="_ZN5clang20TemplateTypeParmTypeC1Ejjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang20TemplateTypeParmTypeC1Ejjb")
  //</editor-fold>
  /*friend*//*package*/ TemplateTypeParmType(/*uint*/int D, /*uint*/int I, boolean PP) {
    // : Type(TemplateTypeParm, QualType(this, 0), /*Dependent=*/ true, /*InstantiationDependent=*/ true, /*VariablyModified=*/ false, PP), FoldingSetNode() 
    //START JInit
    super(TypeClass.TemplateTypeParm, new QualType(/*this, 0*/), 
        true, 
        true, 
        false, PP);
    $Node();
    //END JInit
    Unnamed_field.CanTTPTInfo.Depth = $uint2uint_15bits(D);
    Unnamed_field.CanTTPTInfo.Index = $uint2uint_16bits(I);
    Unnamed_field.CanTTPTInfo.ParameterPack = PP;
  }

  
  /*friend  class ASTContext*/ // ASTContext creates these
  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateTypeParmType::getCanTTPTInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3939,
   FQN="clang::TemplateTypeParmType::getCanTTPTInfo", NM="_ZNK5clang20TemplateTypeParmType14getCanTTPTInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang20TemplateTypeParmType14getCanTTPTInfoEv")
  //</editor-fold>
  private /*const*/ CanonicalTTPTInfo /*&*/ getCanTTPTInfo() /*const*/ {
    QualType Can = getCanonicalTypeInternal();
    return Can.$arrow().castAs$TemplateTypeParmType().Unnamed_field.CanTTPTInfo;
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateTypeParmType::getDepth">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3945,
   FQN="clang::TemplateTypeParmType::getDepth", NM="_ZNK5clang20TemplateTypeParmType8getDepthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang20TemplateTypeParmType8getDepthEv")
  //</editor-fold>
  public /*uint*/int getDepth() /*const*/ {
    return getCanTTPTInfo().Depth;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateTypeParmType::getIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3946,
   FQN="clang::TemplateTypeParmType::getIndex", NM="_ZNK5clang20TemplateTypeParmType8getIndexEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang20TemplateTypeParmType8getIndexEv")
  //</editor-fold>
  public /*uint*/int getIndex() /*const*/ {
    return getCanTTPTInfo().Index;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateTypeParmType::isParameterPack">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3947,
   FQN="clang::TemplateTypeParmType::isParameterPack", NM="_ZNK5clang20TemplateTypeParmType15isParameterPackEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang20TemplateTypeParmType15isParameterPackEv")
  //</editor-fold>
  public boolean isParameterPack() /*const*/ {
    return getCanTTPTInfo().ParameterPack;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateTypeParmType::getDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3949,
   FQN="clang::TemplateTypeParmType::getDecl", NM="_ZNK5clang20TemplateTypeParmType7getDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang20TemplateTypeParmType7getDeclEv")
  //</editor-fold>
  public TemplateTypeParmDecl /*P*/ getDecl() /*const*/ {
    return isCanonicalUnqualified() ? null : Unnamed_field.TTPDecl;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateTypeParmType::getIdentifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 3069,
   FQN="clang::TemplateTypeParmType::getIdentifier", NM="_ZNK5clang20TemplateTypeParmType13getIdentifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang20TemplateTypeParmType13getIdentifierEv")
  //</editor-fold>
  public IdentifierInfo /*P*/ getIdentifier() /*const*/ {
    return isCanonicalUnqualified() ? null : getDecl().getIdentifier();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateTypeParmType::isSugared">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3955,
   FQN="clang::TemplateTypeParmType::isSugared", NM="_ZNK5clang20TemplateTypeParmType9isSugaredEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang20TemplateTypeParmType9isSugaredEv")
  //</editor-fold>
  public boolean isSugared() /*const*/ {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateTypeParmType::desugar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3956,
   FQN="clang::TemplateTypeParmType::desugar", NM="_ZNK5clang20TemplateTypeParmType7desugarEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang20TemplateTypeParmType7desugarEv")
  //</editor-fold>
  public QualType desugar() /*const*/ {
    return new QualType(this, 0);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateTypeParmType::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3958,
   FQN="clang::TemplateTypeParmType::Profile", NM="_ZN5clang20TemplateTypeParmType7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang20TemplateTypeParmType7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  public void Profile(final FoldingSetNodeID /*&*/ ID) {
    Profile(ID, getDepth(), getIndex(), isParameterPack(), getDecl());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateTypeParmType::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3962,
   FQN="clang::TemplateTypeParmType::Profile", NM="_ZN5clang20TemplateTypeParmType7ProfileERN4llvm16FoldingSetNodeIDEjjbPNS_20TemplateTypeParmDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang20TemplateTypeParmType7ProfileERN4llvm16FoldingSetNodeIDEjjbPNS_20TemplateTypeParmDeclE")
  //</editor-fold>
  public static void Profile(final FoldingSetNodeID /*&*/ ID, /*uint*/int Depth, 
         /*uint*/int Index, boolean ParameterPack, 
         TemplateTypeParmDecl /*P*/ TTPDecl) {
    ID.AddInteger_uint(Depth);
    ID.AddInteger_uint(Index);
    ID.AddBoolean(ParameterPack);
    ID.AddPointer(TTPDecl);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateTypeParmType::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3971,
   FQN="clang::TemplateTypeParmType::classof", NM="_ZN5clang20TemplateTypeParmType7classofEPKNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang20TemplateTypeParmType7classofEPKNS_4TypeE")
  //</editor-fold>
  public static boolean classof(/*const*/ Type /*P*/ T) {
    return T.getTypeClass() == TypeClass.TemplateTypeParm;
  }

  @Override public String toString() {
    return "" + "Unnamed_field=" + Unnamed_field // NOI18N
              + super.toString(); // NOI18N
  }
}
