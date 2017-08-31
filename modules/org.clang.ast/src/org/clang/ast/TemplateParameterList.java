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
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;

/// \brief Stores a list of template parameters for a TemplateDecl and its
/// derived classes.
//<editor-fold defaultstate="collapsed" desc="clang::TemplateParameterList">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 49,
 FQN="clang::TemplateParameterList", NM="_ZN5clang21TemplateParameterListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang21TemplateParameterListE")
//</editor-fold>
public final class TemplateParameterList implements /*private*/ TrailingObjects<TemplateParameterList, NamedDecl /*P*/ >, Iterable<NamedDecl> {
  
  /// The location of the 'template' keyword.
  private SourceLocation TemplateLoc;
  
  /// The locations of the '<' and '>' angle brackets.
  private SourceLocation LAngleLoc;
  private SourceLocation RAngleLoc;
  
  /// The number of template parameters in this template
  /// parameter list.
  private /*uint*/int NumParams /*: 31*/;
  
  /// Whether this template parameter list contains an unexpanded parameter
  /// pack.
  private /*JBIT unsigned int*/ boolean ContainsUnexpandedParameterPack /*: 1*/;
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateParameterList::numTrailingObjects">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 67,
   FQN="clang::TemplateParameterList::numTrailingObjects", NM="_ZNK5clang21TemplateParameterList18numTrailingObjectsEN4llvm25trailing_objects_internal19TrailingObjectsBase13OverloadTokenIPNS_9NamedDeclEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang21TemplateParameterList18numTrailingObjectsEN4llvm25trailing_objects_internal19TrailingObjectsBase13OverloadTokenIPNS_9NamedDeclEEE")
  //</editor-fold>
  protected /*size_t*/int numTrailingObjects(TrailingObjects.OverloadToken<NamedDecl /*P*/ > $Prm0) /*const*/ {
    return NumParams;
  }

  
  
  //===----------------------------------------------------------------------===//
  // TemplateParameterList Implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateParameterList::TemplateParameterList">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Trailings*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 31,
   FQN="clang::TemplateParameterList::TemplateParameterList", NM="_ZN5clang21TemplateParameterListC1ENS_14SourceLocationES1_N4llvm8ArrayRefIPNS_9NamedDeclEEES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang21TemplateParameterListC1ENS_14SourceLocationES1_N4llvm8ArrayRefIPNS_9NamedDeclEEES1_")
  //</editor-fold>
  protected TemplateParameterList(type$ptr<NamedDecl /*P*/> $Trailing$Params, SourceLocation TemplateLoc, 
      SourceLocation LAngleLoc, 
      ArrayRef<NamedDecl /*P*/ > Params, 
      SourceLocation RAngleLoc) {
    // : TrailingObjects<TemplateParameterList, NamedDecl * >(), TemplateLoc(TemplateLoc), LAngleLoc(LAngleLoc), RAngleLoc(RAngleLoc), NumParams(Params.size()), ContainsUnexpandedParameterPack(false) 
    this.$Trailing$Params = $toConst($Trailing$Params);// JAVA: prepare trailing memory
    //START JInit
    $TrailingObjects();
    this.TemplateLoc = new SourceLocation(TemplateLoc);
    this.LAngleLoc = new SourceLocation(LAngleLoc);
    this.RAngleLoc = new SourceLocation(RAngleLoc);
    this.NumParams = Params.size();
    this.ContainsUnexpandedParameterPack = false;
    //END JInit
    assert (this.NumParams == $int2uint_31bits(NumParams)) : "Too many template parameters";
    for (/*uint*/int Idx = 0; $less_uint(Idx, NumParams); ++Idx) {
      NamedDecl /*P*/ P = Params.$at(Idx);
      begin().$set(Idx, P);
      if (!P.isTemplateParameterPack()) {
        {
          NonTypeTemplateParmDecl /*P*/ NTTP = dyn_cast_NonTypeTemplateParmDecl(P);
          if ((NTTP != null)) {
            if (NTTP.getType().$arrow().containsUnexpandedParameterPack()) {
              ContainsUnexpandedParameterPack = true;
            }
          }
        }
        {
          
          TemplateTemplateParmDecl /*P*/ TTP = dyn_cast_TemplateTemplateParmDecl(P);
          if ((TTP != null)) {
            if (TTP.getTemplateParameters().containsUnexpandedParameterPack()) {
              ContainsUnexpandedParameterPack = true;
            }
          }
        }
        // FIXME: If a default argument contains an unexpanded parameter pack, the
        // template parameter list does too.
      }
    }
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateParameterList::Create">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Alloc*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 57,
   FQN="clang::TemplateParameterList::Create", NM="_ZN5clang21TemplateParameterList6CreateERKNS_10ASTContextENS_14SourceLocationES4_N4llvm8ArrayRefIPNS_9NamedDeclEEES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang21TemplateParameterList6CreateERKNS_10ASTContextENS_14SourceLocationES4_N4llvm8ArrayRefIPNS_9NamedDeclEEES4_")
  //</editor-fold>
  public static TemplateParameterList /*P*/ Create(final /*const*/ ASTContext /*&*/ C, SourceLocation TemplateLoc, SourceLocation LAngleLoc, 
        ArrayRef<NamedDecl /*P*/ > Params, SourceLocation RAngleLoc) {
    // JAVA: MEMORY
    Object/*void P*/ Mem = C.Allocate$JavaRef(TrailingObjects.totalSizeToAlloc$Same(NamedDecl.class, Params.size()), 
        true ? 1 : alignOf(TemplateParameterList.class));
    return /*NEW_EXPR [System]*//*new (Mem)*/ $new_uint_voidPtr(Mem, (type$ptr<?> New$Mem)->{
        return new TemplateParameterList((type$ptr<NamedDecl /*P*/>)New$Mem.$add(1), new SourceLocation(TemplateLoc), new SourceLocation(LAngleLoc), new ArrayRef<NamedDecl /*P*/ >(Params), 
                new SourceLocation(RAngleLoc));
     });
  }

  
  /// \brief Iterates through the template parameters in this list.
  /*typedef NamedDecl **iterator*/
//  public final class iterator extends type$ptr<NamedDecl /*P*/ /*P*/>{ };
  
  /// \brief Iterates through the template parameters in this list.
  /*typedef NamedDecl *const *const_iterator*/
//  public final class const_iterator extends type$ptr<NamedDecl /*P*/ /*const*/ /*P*/>{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateParameterList::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 87,
   FQN="clang::TemplateParameterList::begin", NM="_ZN5clang21TemplateParameterList5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang21TemplateParameterList5beginEv")
  //</editor-fold>
  public type$ptr<NamedDecl /*P*/ /*P*/> begin() {
    return getTrailingObjects(NamedDecl /*P*/.class);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateParameterList::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 88,
   FQN="clang::TemplateParameterList::begin", NM="_ZNK5clang21TemplateParameterList5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang21TemplateParameterList5beginEv")
  //</editor-fold>
  public type$ptr<NamedDecl /*P*/ /*const*/ /*P*/> begin$Const() /*const*/ {
    return getTrailingObjects$Const(NamedDecl /*P*/.class);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateParameterList::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 89,
   FQN="clang::TemplateParameterList::end", NM="_ZN5clang21TemplateParameterList3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang21TemplateParameterList3endEv")
  //</editor-fold>
  public type$ptr<NamedDecl /*P*/ /*P*/> end() {
    return begin().$add(NumParams);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateParameterList::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 90,
   FQN="clang::TemplateParameterList::end", NM="_ZNK5clang21TemplateParameterList3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang21TemplateParameterList3endEv")
  //</editor-fold>
  public type$ptr<NamedDecl /*P*/ /*const*/ /*P*/> end$Const() /*const*/ {
    return begin$Const().$add(NumParams);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateParameterList::size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 92,
   FQN="clang::TemplateParameterList::size", NM="_ZNK5clang21TemplateParameterList4sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang21TemplateParameterList4sizeEv")
  //</editor-fold>
  public /*uint*/int size() /*const*/ {
    return NumParams;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateParameterList::asArray">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 94,
   FQN="clang::TemplateParameterList::asArray", NM="_ZN5clang21TemplateParameterList7asArrayEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang21TemplateParameterList7asArrayEv")
  //</editor-fold>
  public ArrayRef<NamedDecl /*P*/ > asArray() {
    return llvm.makeArrayRef(begin(), end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateParameterList::asArray">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 97,
   FQN="clang::TemplateParameterList::asArray", NM="_ZNK5clang21TemplateParameterList7asArrayEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang21TemplateParameterList7asArrayEv")
  //</editor-fold>
  public ArrayRef</*const*/ NamedDecl /*P*/ > asArray$Const() /*const*/ {
    return new ArrayRef</*const*/ NamedDecl /*P*/ >(JD$Convertible.INSTANCE, llvm.makeArrayRef(begin$Const(), size()), true);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateParameterList::getParam">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 101,
   FQN="clang::TemplateParameterList::getParam", NM="_ZN5clang21TemplateParameterList8getParamEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang21TemplateParameterList8getParamEj")
  //</editor-fold>
  public NamedDecl /*P*/ getParam(/*uint*/int Idx) {
    assert ($less_uint(Idx, size())) : "Template parameter index out-of-range";
    return begin().$at(Idx);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateParameterList::getParam">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 106,
   FQN="clang::TemplateParameterList::getParam", NM="_ZNK5clang21TemplateParameterList8getParamEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang21TemplateParameterList8getParamEj")
  //</editor-fold>
  public /*const*/ NamedDecl /*P*/ getParam$Const(/*uint*/int Idx) /*const*/ {
    assert ($less_uint(Idx, size())) : "Template parameter index out-of-range";
    return begin$Const().$at(Idx);
  }

  
  /// \brief Returns the minimum number of arguments needed to form a
  /// template specialization.
  ///
  /// This may be fewer than the number of template parameters, if some of
  /// the parameters have default arguments or if there is a parameter pack.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateParameterList::getMinRequiredArguments">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 66,
   FQN="clang::TemplateParameterList::getMinRequiredArguments", NM="_ZNK5clang21TemplateParameterList23getMinRequiredArgumentsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang21TemplateParameterList23getMinRequiredArgumentsEv")
  //</editor-fold>
  public /*uint*/int getMinRequiredArguments() /*const*/ {
    /*uint*/int NumRequiredArgs = 0;
    for (/*const*/ NamedDecl /*P*/ P : asArray$Const()) {
      if (P.isTemplateParameterPack()) {
        {
          /*const*/ NonTypeTemplateParmDecl /*P*/ NTTP = dyn_cast_NonTypeTemplateParmDecl(P);
          if ((NTTP != null)) {
            if (NTTP.isExpandedParameterPack()) {
              NumRequiredArgs += NTTP.getNumExpansionTypes();
              continue;
            }
          }
        }
        
        break;
      }
      {
        
        /*const*/ TemplateTypeParmDecl /*P*/ TTP = dyn_cast_TemplateTypeParmDecl(P);
        if ((TTP != null)) {
          if (TTP.hasDefaultArgument()) {
            break;
          }
        } else {
          /*const*/ NonTypeTemplateParmDecl /*P*/ NTTP = dyn_cast_NonTypeTemplateParmDecl(P);
          if ((NTTP != null)) {
            if (NTTP.hasDefaultArgument()) {
              break;
            }
          } else if (cast_TemplateTemplateParmDecl(P).hasDefaultArgument()) {
            break;
          }
        }
      }
      
      ++NumRequiredArgs;
    }
    
    return NumRequiredArgs;
  }

  
  /// \brief Get the depth of this template parameter list in the set of
  /// template parameter lists.
  ///
  /// The first template parameter list in a declaration will have depth 0,
  /// the second template parameter list will have depth 1, etc.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateParameterList::getDepth">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 94,
   FQN="clang::TemplateParameterList::getDepth", NM="_ZNK5clang21TemplateParameterList8getDepthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang21TemplateParameterList8getDepthEv")
  //</editor-fold>
  public /*uint*/int getDepth() /*const*/ {
    if (size() == 0) {
      return 0;
    }
    
    /*const*/ NamedDecl /*P*/ FirstParm = getParam$Const(0);
    {
      /*const*/ TemplateTypeParmDecl /*P*/ TTP = dyn_cast_TemplateTypeParmDecl(FirstParm);
      if ((TTP != null)) {
        return TTP.getDepth();
      } else {
        /*const*/ NonTypeTemplateParmDecl /*P*/ NTTP = dyn_cast_NonTypeTemplateParmDecl(FirstParm);
        if ((NTTP != null)) {
          return NTTP.getDepth();
        } else {
          return cast_TemplateTemplateParmDecl(FirstParm).getDepth();
        }
      }
    }
  }

  
  /// \brief Determine whether this template parameter list contains an
  /// unexpanded parameter pack.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateParameterList::containsUnexpandedParameterPack">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 127,
   FQN="clang::TemplateParameterList::containsUnexpandedParameterPack", NM="_ZNK5clang21TemplateParameterList31containsUnexpandedParameterPackEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang21TemplateParameterList31containsUnexpandedParameterPackEv")
  //</editor-fold>
  public boolean containsUnexpandedParameterPack() /*const*/ {
    return ContainsUnexpandedParameterPack;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateParameterList::getTemplateLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 131,
   FQN="clang::TemplateParameterList::getTemplateLoc", NM="_ZNK5clang21TemplateParameterList14getTemplateLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang21TemplateParameterList14getTemplateLocEv")
  //</editor-fold>
  public SourceLocation getTemplateLoc() /*const*/ {
    return new SourceLocation(TemplateLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateParameterList::getLAngleLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 132,
   FQN="clang::TemplateParameterList::getLAngleLoc", NM="_ZNK5clang21TemplateParameterList12getLAngleLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang21TemplateParameterList12getLAngleLocEv")
  //</editor-fold>
  public SourceLocation getLAngleLoc() /*const*/ {
    return new SourceLocation(LAngleLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateParameterList::getRAngleLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 133,
   FQN="clang::TemplateParameterList::getRAngleLoc", NM="_ZNK5clang21TemplateParameterList12getRAngleLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang21TemplateParameterList12getRAngleLocEv")
  //</editor-fold>
  public SourceLocation getRAngleLoc() /*const*/ {
    return new SourceLocation(RAngleLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateParameterList::getSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 135,
   FQN="clang::TemplateParameterList::getSourceRange", NM="_ZNK5clang21TemplateParameterList14getSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang21TemplateParameterList14getSourceRangeEv")
  //</editor-fold>
  public SourceRange getSourceRange() /*const*//* __attribute__((pure))*/ {
    return new SourceRange(/*NO_COPY*/TemplateLoc, /*NO_COPY*/RAngleLoc);
  }

  
  /*friend  TrailingObjects<TemplateParameterList, NamedDecl *>*/
  /*friend template <size_t N> class FixedSizeTemplateParameterListStorage*/
  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override
  public java.util.Iterator<NamedDecl> iterator() {
    return new JavaIterator<NamedDecl>(begin(), end());
  }

  @Override
  public </*typename*/ T> type$ptr<T> getTrailingObjects(Class<T> clazz) {
    assert clazz == NamedDecl.class : "unexpected class " + clazz; 
    return (type$ptr<T>)$Trailing$Params;
  }

  private final type$ptr<NamedDecl /*P*/> $Trailing$Params;
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "TemplateLoc=" + TemplateLoc // NOI18N
              + ", LAngleLoc=" + LAngleLoc // NOI18N
              + ", RAngleLoc=" + RAngleLoc // NOI18N
              + ", NumParams=" + NumParams // NOI18N
              + ", ContainsUnexpandedParameterPack=" + ContainsUnexpandedParameterPack // NOI18N
              + super.toString(); // NOI18N
  }
}
