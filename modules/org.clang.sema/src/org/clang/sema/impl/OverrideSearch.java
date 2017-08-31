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

package org.clang.sema.impl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.sema.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;


/// A helper class for searching for methods which a particular method
/// overrides.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OverrideSearch">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 3950,
 FQN="(anonymous namespace)::OverrideSearch", NM="_ZN12_GLOBAL__N_114OverrideSearchE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZN12_GLOBAL__N_114OverrideSearchE")
//</editor-fold>
public class OverrideSearch implements Destructors.ClassWithDestructor {
/*public:*/
  public final Sema /*&*/ S;
  public ObjCMethodDecl /*P*/ Method;
  public SmallPtrSet<ObjCMethodDecl /*P*/ > Overridden;
  public boolean Recursive;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OverrideSearch::OverrideSearch">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 3958,
   FQN="(anonymous namespace)::OverrideSearch::OverrideSearch", NM="_ZN12_GLOBAL__N_114OverrideSearchC1ERN5clang4SemaEPNS1_14ObjCMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZN12_GLOBAL__N_114OverrideSearchC1ERN5clang4SemaEPNS1_14ObjCMethodDeclE")
  //</editor-fold>
  public OverrideSearch(final Sema /*&*/ S, ObjCMethodDecl /*P*/ method) {
    // : S(S), Method(method), Overridden() 
    //START JInit
    this./*&*/S=/*&*/S;
    this.Method = method;
    this.Overridden = new SmallPtrSet<ObjCMethodDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 4);
    //END JInit
    Selector selector = method.getSelector();
    
    // Bypass this search if we've never seen an instance/class method
    // with this selector before.
    DenseMapIterator<Selector, pair<ObjCMethodList, ObjCMethodList>> it = S.MethodPool.find(selector);
    if (it.$eq(/*NO_ITER_COPY*/S.MethodPool.end())) {
      if (!(S.getExternalSource() != null)) {
        return;
      }
      S.ReadMethodPool(new Selector(selector));
      
      it.$assignMove(S.MethodPool.find(selector));
      if (it.$eq(/*NO_ITER_COPY*/S.MethodPool.end())) {
        return;
      }
    }
    final ObjCMethodList /*&*/ list = method.isInstanceMethod() ? it.$arrow().second.first : it.$arrow().second.second;
    if (!(list.getMethod() != null)) {
      return;
    }
    
    ObjCContainerDecl /*P*/ container = cast_ObjCContainerDecl(method.getDeclContext());
    {
      
      // Prevent the search from reaching this container again.  This is
      // important with categories, which override methods from the
      // interface and each other.
      ObjCCategoryDecl /*P*/ Category = dyn_cast_ObjCCategoryDecl(container);
      if ((Category != null)) {
        searchFromContainer(container);
        {
          ObjCInterfaceDecl /*P*/ Interface = Category.getClassInterface();
          if ((Interface != null)) {
            searchFromContainer(Interface);
          }
        }
      } else {
        searchFromContainer(container);
      }
    }
  }

  
  /*typedef llvm::SmallPtrSetImpl<ObjCMethodDecl *>::iterator iterator*/
//  public final class iterator extends SmallPtrSetIterator<ObjCMethodDecl /*P*/ >{ };
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OverrideSearch::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 3992,
   FQN="(anonymous namespace)::OverrideSearch::begin", NM="_ZNK12_GLOBAL__N_114OverrideSearch5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZNK12_GLOBAL__N_114OverrideSearch5beginEv")
  //</editor-fold>
  public SmallPtrSetIterator<ObjCMethodDecl /*P*/ > begin() /*const*/ {
    return Overridden.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OverrideSearch::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 3993,
   FQN="(anonymous namespace)::OverrideSearch::end", NM="_ZNK12_GLOBAL__N_114OverrideSearch3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZNK12_GLOBAL__N_114OverrideSearch3endEv")
  //</editor-fold>
  public SmallPtrSetIterator<ObjCMethodDecl /*P*/ > end() /*const*/ {
    return Overridden.end();
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OverrideSearch::searchFromContainer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 3996,
   FQN="(anonymous namespace)::OverrideSearch::searchFromContainer", NM="_ZN12_GLOBAL__N_114OverrideSearch19searchFromContainerEPN5clang17ObjCContainerDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZN12_GLOBAL__N_114OverrideSearch19searchFromContainerEPN5clang17ObjCContainerDeclE")
  //</editor-fold>
  private void searchFromContainer(ObjCContainerDecl /*P*/ container) {
    if (container.isInvalidDecl()) {
      return;
    }
    switch (container.getDeclKind()) {
     case AccessSpec:
     case Block:
     case Captured:
     case ClassScopeFunctionSpecialization:
     case Empty:
     case ExternCContext:
     case FileScopeAsm:
     case Friend:
     case FriendTemplate:
     case Import:
     case LinkageSpec:
     case Label:
     case Namespace:
     case NamespaceAlias:
     case ObjCCompatibleAlias:
     case ObjCCategory:
      searchFrom(cast_ObjCCategoryDecl(container));
      break;
     case ObjCCategoryImpl:
      searchFrom(cast_ObjCCategoryImplDecl(container));
      break;
     case ObjCImplementation:
      searchFrom(cast_ObjCImplementationDecl(container));
      break;
     case ObjCInterface:
      searchFrom(cast_ObjCInterfaceDecl(container));
      break;
     case ObjCProtocol:
      searchFrom(cast_ObjCProtocolDecl(container));
      break;
     case ObjCMethod:
     case ObjCProperty:
     case BuiltinTemplate:
     case ClassTemplate:
     case FunctionTemplate:
     case TypeAliasTemplate:
     case VarTemplate:
     case TemplateTemplateParm:
     case Enum:
     case Record:
     case CXXRecord:
     case ClassTemplateSpecialization:
     case ClassTemplatePartialSpecialization:
     case TemplateTypeParm:
     case ObjCTypeParam:
     case TypeAlias:
     case Typedef:
     case UnresolvedUsingTypename:
     case Using:
     case UsingDirective:
     case UsingShadow:
     case ConstructorUsingShadow:
     case Field:
     case ObjCAtDefsField:
     case ObjCIvar:
     case Function:
     case CXXMethod:
     case CXXConstructor:
     case CXXConversion:
     case CXXDestructor:
     case MSProperty:
     case NonTypeTemplateParm:
     case Var:
     case ImplicitParam:
     case OMPCapturedExpr:
     case ParmVar:
     case VarTemplateSpecialization:
     case VarTemplatePartialSpecialization:
     case EnumConstant:
     case IndirectField:
     case OMPDeclareReduction:
     case UnresolvedUsingValue:
     case OMPThreadPrivate:
     case ObjCPropertyImpl:
     case PragmaComment:
     case PragmaDetectMismatch:
     case StaticAssert:
     case TranslationUnit:
      throw new llvm_unreachable("not an ObjC container!");
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OverrideSearch::searchFrom">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 4012,
   FQN="(anonymous namespace)::OverrideSearch::searchFrom", NM="_ZN12_GLOBAL__N_114OverrideSearch10searchFromEPN5clang16ObjCProtocolDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZN12_GLOBAL__N_114OverrideSearch10searchFromEPN5clang16ObjCProtocolDeclE")
  //</editor-fold>
  private void searchFrom(ObjCProtocolDecl /*P*/ protocol) {
    if (!protocol.hasDefinition()) {
      return;
    }
    
    // A method in a protocol declaration overrides declarations from
    // referenced ("parent") protocols.
    search(protocol.getReferencedProtocols());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OverrideSearch::searchFrom">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 4021,
   FQN="(anonymous namespace)::OverrideSearch::searchFrom", NM="_ZN12_GLOBAL__N_114OverrideSearch10searchFromEPN5clang16ObjCCategoryDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZN12_GLOBAL__N_114OverrideSearch10searchFromEPN5clang16ObjCCategoryDeclE")
  //</editor-fold>
  private void searchFrom(ObjCCategoryDecl /*P*/ category) {
    // A method in a category declaration overrides declarations from
    // the main class and from protocols the category references.
    // The main class is handled in the constructor.
    search(category.getReferencedProtocols());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OverrideSearch::searchFrom">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 4028,
   FQN="(anonymous namespace)::OverrideSearch::searchFrom", NM="_ZN12_GLOBAL__N_114OverrideSearch10searchFromEPN5clang20ObjCCategoryImplDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZN12_GLOBAL__N_114OverrideSearch10searchFromEPN5clang20ObjCCategoryImplDeclE")
  //</editor-fold>
  private void searchFrom(ObjCCategoryImplDecl /*P*/ impl) {
    {
      // A method in a category definition that has a category
      // declaration overrides declarations from the category
      // declaration.
      ObjCCategoryDecl /*P*/ category = impl.getCategoryDecl();
      if ((category != null)) {
        search(category);
        {
          ObjCInterfaceDecl /*P*/ Interface = category.getClassInterface();
          if ((Interface != null)) {
            search(Interface);
          }
        }
        // Otherwise it overrides declarations from the class.
      } else {
        ObjCInterfaceDecl /*P*/ Interface = impl.getClassInterface();
        if ((Interface != null)) {
          search(Interface);
        }
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OverrideSearch::searchFrom">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 4043,
   FQN="(anonymous namespace)::OverrideSearch::searchFrom", NM="_ZN12_GLOBAL__N_114OverrideSearch10searchFromEPN5clang17ObjCInterfaceDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZN12_GLOBAL__N_114OverrideSearch10searchFromEPN5clang17ObjCInterfaceDeclE")
  //</editor-fold>
  private void searchFrom(ObjCInterfaceDecl /*P*/ iface) {
    // A method in a class declaration overrides declarations from
    if (!iface.hasDefinition()) {
      return;
    }
    
    //   - categories,
    for (ObjCCategoryDecl /*P*/ Cat : iface.known_categories())  {
      search(Cat);
    }
    {
      
      //   - the super class, and
      ObjCInterfaceDecl /*P*/ __super = iface.getSuperClass();
      if ((__super != null)) {
        search(__super);
      }
    }
    
    //   - any referenced protocols.
    search(iface.getReferencedProtocols());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OverrideSearch::searchFrom">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 4060,
   FQN="(anonymous namespace)::OverrideSearch::searchFrom", NM="_ZN12_GLOBAL__N_114OverrideSearch10searchFromEPN5clang22ObjCImplementationDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZN12_GLOBAL__N_114OverrideSearch10searchFromEPN5clang22ObjCImplementationDeclE")
  //</editor-fold>
  private void searchFrom(ObjCImplementationDecl /*P*/ impl) {
    {
      // A method in a class implementation overrides declarations from
      // the class interface.
      ObjCInterfaceDecl /*P*/ Interface = impl.getClassInterface();
      if ((Interface != null)) {
        search(Interface);
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OverrideSearch::search">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 4067,
   FQN="(anonymous namespace)::OverrideSearch::search", NM="_ZN12_GLOBAL__N_114OverrideSearch6searchERKN5clang16ObjCProtocolListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZN12_GLOBAL__N_114OverrideSearch6searchERKN5clang16ObjCProtocolListE")
  //</editor-fold>
  private void search(final /*const*/ ObjCProtocolList /*&*/ protocols) {
    for (type$ptr<ObjCProtocolDecl/*P const*/>/*P*/ i = $tryClone(protocols.begin()), e = $tryClone(protocols.end());
         $noteq_ptr(i, e); i.$preInc())  {
      search(i.$star());
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OverrideSearch::search">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 4073,
   FQN="(anonymous namespace)::OverrideSearch::search", NM="_ZN12_GLOBAL__N_114OverrideSearch6searchEPN5clang17ObjCContainerDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZN12_GLOBAL__N_114OverrideSearch6searchEPN5clang17ObjCContainerDeclE")
  //</editor-fold>
  private void search(ObjCContainerDecl /*P*/ container) {
    // Check for a method in this container which matches this selector.
    ObjCMethodDecl /*P*/ meth = container.getMethod(Method.getSelector(), 
        Method.isInstanceMethod(), 
        /*AllowHidden=*/ true);
    
    // If we find one, record it and bail out.
    if ((meth != null)) {
      Overridden.insert(meth);
      return;
    }
    
    // Otherwise, search for methods that a hypothetical method here
    // would have overridden.
    
    // Note that we're now in a recursive case.
    Recursive = true;
    
    searchFromContainer(container);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OverrideSearch::~OverrideSearch">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 3950,
   FQN="(anonymous namespace)::OverrideSearch::~OverrideSearch", NM="_ZN12_GLOBAL__N_114OverrideSearchD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZN12_GLOBAL__N_114OverrideSearchD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Overridden.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "S=" + "[Sema]" // NOI18N
              + ", Method=" + Method // NOI18N
              + ", Overridden=" + Overridden // NOI18N
              + ", Recursive=" + Recursive; // NOI18N
  }
}
