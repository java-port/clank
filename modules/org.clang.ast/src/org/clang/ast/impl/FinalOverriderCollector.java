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

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import static org.clang.ast.java.AstJavaFixedRTTI.*;
import org.clank.java.stdimpl.aliases.StdVector;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FinalOverriderCollector">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp", line = 470,
 FQN="(anonymous namespace)::FinalOverriderCollector", NM="_ZN12_GLOBAL__N_123FinalOverriderCollectorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp -nm=_ZN12_GLOBAL__N_123FinalOverriderCollectorE")
//</editor-fold>
public class FinalOverriderCollector implements Destructors.ClassWithDestructor {
  /// \brief The number of subobjects of a given class type that
  /// occur within the class hierarchy.
  private DenseMapTypeUInt</*const*/ CXXRecordDecl /*P*/ > SubobjectCount;
  
  /// \brief Overriders for each virtual base subobject.
  private DenseMap</*const*/ CXXRecordDecl /*P*/ , CXXFinalOverriderMap /*P*/ > VirtualOverriders;
  
  private CXXFinalOverriderMap FinalOverriders;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FinalOverriderCollector::~FinalOverriderCollector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp", line = 615,
   FQN="(anonymous namespace)::FinalOverriderCollector::~FinalOverriderCollector", NM="_ZN12_GLOBAL__N_123FinalOverriderCollectorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp -nm=_ZN12_GLOBAL__N_123FinalOverriderCollectorD0Ev")
  //</editor-fold>
  public void $destroy() {
    for (DenseMapIterator</*const*/ CXXRecordDecl /*P*/ , CXXFinalOverriderMap /*P*/ > VO = VirtualOverriders.begin(), VOEnd = VirtualOverriders.end();
         VO.$noteq(/*NO_ITER_COPY*/VOEnd);
         VO.$preInc())  {
      if (VO.$arrow().second != null) { VO.$arrow().second.$destroy();};
    }
    //START JDestroy
    FinalOverriders.$destroy();
    VirtualOverriders.$destroy();
    SubobjectCount.$destroy();
    //END JDestroy
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FinalOverriderCollector::Collect">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp", line = 489,
   FQN="(anonymous namespace)::FinalOverriderCollector::Collect", NM="_ZN12_GLOBAL__N_123FinalOverriderCollector7CollectEPKN5clang13CXXRecordDeclEbS4_RNS1_20CXXFinalOverriderMapE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp -nm=_ZN12_GLOBAL__N_123FinalOverriderCollector7CollectEPKN5clang13CXXRecordDeclEbS4_RNS1_20CXXFinalOverriderMapE")
  //</editor-fold>
  public void Collect(/*const*/ CXXRecordDecl /*P*/ RD, 
         boolean VirtualBase, 
         /*const*/ CXXRecordDecl /*P*/ InVirtualSubobject, 
         final CXXFinalOverriderMap /*&*/ Overriders) {
    /*uint*/int SubobjectNumber = 0;
    if (!VirtualBase) {
      SubobjectNumber
         = SubobjectCount.ref$at(cast_CXXRecordDecl(RD.getCanonicalDecl$Const())).$set$preInc();
    }
    
    for (final /*const*/ CXXBaseSpecifier /*&*/ Base : RD.bases$Const()) {
      {
        /*const*/ RecordType /*P*/ RT = Base.getType().$arrow().getAs$RecordType();
        if ((RT != null)) {
          CXXFinalOverriderMap ComputedBaseOverriders = null;
          try {
            /*const*/ CXXRecordDecl /*P*/ BaseDecl = cast_CXXRecordDecl(RT.getDecl());
            if (!BaseDecl.isPolymorphic()) {
              continue;
            }
            if (Overriders.empty() && !Base.isVirtual()) {
              // There are no other overriders of virtual member functions,
              // so let the base class fill in our overriders for us.
              Collect(BaseDecl, false, InVirtualSubobject, Overriders);
              continue;
            }
            
            // Collect all of the overridders from the base class subobject
            // and merge them into the set of overridders for this class.
            // For virtual base classes, populate or use the cached virtual
            // overrides so that we do not walk the virtual base class (and
            // its base classes) more than once.
            ComputedBaseOverriders/*J*/= new CXXFinalOverriderMap();
            CXXFinalOverriderMap /*P*/ BaseOverriders = $AddrOf(ComputedBaseOverriders);
            if (Base.isVirtual()) {
              final type$ref<CXXFinalOverriderMap /*P*/ /*&*/> MyVirtualOverriders = VirtualOverriders.ref$at(BaseDecl);
              BaseOverriders = MyVirtualOverriders.$deref();
              if (!(MyVirtualOverriders.$deref() != null)) {
                MyVirtualOverriders.$set(new CXXFinalOverriderMap());
                
                // Collect may cause VirtualOverriders to reallocate, invalidating the
                // MyVirtualOverriders reference. Set BaseOverriders to the right
                // value now.
                BaseOverriders = MyVirtualOverriders.$deref();
                
                Collect(BaseDecl, true, BaseDecl, $Deref(MyVirtualOverriders.$deref()));
              }
            } else {
              Collect(BaseDecl, false, InVirtualSubobject, ComputedBaseOverriders);
            }
            
            // Merge the overriders from this base class into our own set of
            // overriders.
            for (StdVector.iterator<pairPtrType</*const*/ CXXMethodDecl/*P*/, OverridingMethods/*P*/>> OM = BaseOverriders.begin(), 
                OMEnd = BaseOverriders.end();
                 $noteq___normal_iterator$C(OM, OMEnd);
                 OM.$preInc()) {
              /*const*/ CXXMethodDecl /*P*/ CanonOM = cast_CXXMethodDecl(OM.$arrow().first.getCanonicalDecl$Const());
              Overriders.$at(CanonOM).add(OM.$arrow().second);
            }
          } finally {
            if (ComputedBaseOverriders != null) { ComputedBaseOverriders.$destroy(); }
          }
        }
      }
    }
    
    for (CXXMethodDecl /*P*/ M : RD.methods()) {
      // We only care about virtual methods.
      if (!M.isVirtual()) {
        continue;
      }
      
      CXXMethodDecl /*P*/ CanonM = cast_CXXMethodDecl(M.getCanonicalDecl());
      if ($eq_ptr(CanonM.begin_overridden_methods(), CanonM.end_overridden_methods())) {
        // This is a new virtual function that does not override any
        // other virtual function. Add it to the map of virtual
        // functions for which we are tracking overridders. 
        
        // C++ [class.virtual]p2:
        //   For convenience we say that any virtual function overrides itself.
        Overriders.$at(CanonM).add(SubobjectNumber, 
            new UniqueVirtualMethod(CanonM, SubobjectNumber, 
                InVirtualSubobject));
        continue;
      }
      
      // This virtual method overrides other virtual methods, so it does
      // not add any new slots into the set of overriders. Instead, we
      // replace entries in the set of overriders with the new
      // overrider. To do so, we dig down to the original virtual
      // functions using data recursion and update all of the methods it
      // overrides.
      /*typedef llvm::iterator_range<CXXMethodDecl::method_iterator> OverriddenMethods*/
//      final class OverriddenMethods extends iterator_range</*const*/ CXXMethodDecl /*P*/ /*const*/>{ };
      SmallVector<iterator_range</*const*/ CXXMethodDecl /*P*/ /*const*/>> Stack/*J*/= new SmallVector<iterator_range</*const*/ CXXMethodDecl /*P*/ /*const*/>>(4, new iterator_range</*const*/ CXXMethodDecl /*P*/ /*const*/>());
      Stack.push_back(llvm.make_range(CanonM.begin_overridden_methods(), 
              CanonM.end_overridden_methods()));
      while (!Stack.empty()) {
        for (/*const*/ CXXMethodDecl /*P*/ OM : Stack.pop_back_val()) {
          /*const*/ CXXMethodDecl /*P*/ CanonOM = OM.getCanonicalDecl$Const();
          
          // C++ [class.virtual]p2:
          //   A virtual member function C::vf of a class object S is
          //   a final overrider unless the most derived class (1.8)
          //   of which S is a base class subobject (if any) declares
          //   or inherits another member function that overrides vf.
          //
          // Treating this object like the most derived class, we
          // replace any overrides from base classes with this
          // overriding virtual function.
          Overriders.$at(CanonOM).replaceAll(new UniqueVirtualMethod(CanonM, SubobjectNumber, 
                  InVirtualSubobject));
          if ($eq_ptr(CanonOM.begin_overridden_methods(), CanonOM.end_overridden_methods())) {
            continue;
          }
          
          // Continue recursion to the methods that this virtual method
          // overrides.
          Stack.push_back(llvm.make_range(CanonOM.begin_overridden_methods(), 
                  CanonOM.end_overridden_methods()));
        }
      }
      
      // C++ [class.virtual]p2:
      //   For convenience we say that any virtual function overrides itself.
      Overriders.$at(CanonM).add(SubobjectNumber, 
          new UniqueVirtualMethod(CanonM, SubobjectNumber, 
              InVirtualSubobject));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FinalOverriderCollector::FinalOverriderCollector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp", line = 470,
   FQN="(anonymous namespace)::FinalOverriderCollector::FinalOverriderCollector", NM="_ZN12_GLOBAL__N_123FinalOverriderCollectorC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp -nm=_ZN12_GLOBAL__N_123FinalOverriderCollectorC1Ev")
  //</editor-fold>
  public /*inline*/ FinalOverriderCollector() {
    // : SubobjectCount(), VirtualOverriders(), FinalOverriders() 
    //START JInit
    this.SubobjectCount = new DenseMapTypeUInt</*const*/ CXXRecordDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 0);
    this.VirtualOverriders = new DenseMap</*const*/ CXXRecordDecl /*P*/ , CXXFinalOverriderMap /*P*/ >(DenseMapInfo$LikePtr.$Info(), (CXXFinalOverriderMap /*P*/ )null);
    this.FinalOverriders = new CXXFinalOverriderMap();
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "SubobjectCount=" + SubobjectCount // NOI18N
              + ", VirtualOverriders=" + VirtualOverriders // NOI18N
              + ", FinalOverriders=" + FinalOverriders; // NOI18N
  }
}
